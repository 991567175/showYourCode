package com.usefactoryandannotation1.factory;

import com.usefactoryandannotation1.annotation.DateType;
import com.usefactoryandannotation1.enums.DateTypeEnum;
import com.usefactoryandannotation1.service.DateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现InitializingBean接口的afterPropertiesSet方法，也能实现同样的功能
 */
@Component
@Slf4j
public class DateTypeFactory implements BeanPostProcessor {

    private final Map<DateTypeEnum, DateTypeService> dateTypeHandlerMap = new ConcurrentHashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DateTypeService) {
            DateType annotation = AnnotationUtils.findAnnotation(bean.getClass(), DateType.class);
            /**
             * 当bean为代理类（比如该类中有@Transactional注解）时，.getAnnotation(DateType.class)返回null
             * 而AnnotationUtils.findAnnotation(bean.getClass(), DateType.class)可以解决这个问题
             */
//            DateType annotation = bean.getClass().getAnnotation(DateType.class);
            if (Objects.nonNull(annotation)) {
                DateTypeEnum dateTypeEnum = annotation.value();
                dateTypeHandlerMap.put(dateTypeEnum, (DateTypeService) bean);
                if (AopUtils.isAopProxy(bean)) {
                    log.info(beanName);
                }
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public DateTypeService getService(Integer dateTypeCode) {
        DateTypeEnum dateTypeEnum = DateTypeEnum.getEnumByCode(dateTypeCode);
        if (Objects.isNull(dateTypeEnum)) {
            throw new RuntimeException();
        }
        return this.dateTypeHandlerMap.get(dateTypeEnum);
    }

}
