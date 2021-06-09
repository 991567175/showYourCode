package com.showYourCode.cleanIfElse.useFactory;

import com.showYourCode.cleanIfElse.useEnum.DateTypeEnum;
import com.showYourCode.cleanIfElse.useFactory.handler.DateTypeOfMonthHandler;
import com.showYourCode.cleanIfElse.useFactory.handler.DateTypeOfQuarterHandler;
import com.showYourCode.cleanIfElse.useFactory.handler.DateTypeOfYearHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现InitializingBean接口的afterPropertiesSet方法，也能实现同样的功能
 */
@Component
public class DateTypeFactory1 implements BeanPostProcessor {

    @Autowired
    private DateTypeOfMonthHandler dateTypeOfMonthHandler;
    @Autowired
    private DateTypeOfQuarterHandler dateTypeOfQuarterHandler;
    @Autowired
    private DateTypeOfYearHandler dateTypeOfYearHandler;

    private final Map<DateTypeEnum, DateTypeHandler> dateTypeHandlerMap = new ConcurrentHashMap<>(3);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        dateTypeHandlerMap.put(DateTypeEnum.MONTH, dateTypeOfMonthHandler);
        dateTypeHandlerMap.put(DateTypeEnum.QUARTER, dateTypeOfQuarterHandler);
        dateTypeHandlerMap.put(DateTypeEnum.YEAR, dateTypeOfYearHandler);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public DateTypeHandler getHandler(Integer dateTypeCode) {
        DateTypeEnum dateTypeEnum = DateTypeEnum.getEnumByCode(dateTypeCode);
        if (Objects.isNull(dateTypeEnum)) {
            throw new RuntimeException();
        }
        return this.dateTypeHandlerMap.get(dateTypeEnum);
    }

}
