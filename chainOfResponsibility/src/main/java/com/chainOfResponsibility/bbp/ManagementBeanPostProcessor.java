package com.chainOfResponsibility.bbp;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import com.chainOfResponsibility.management.ManagementHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ManagementBeanPostProcessor implements BeanPostProcessor {

    private final Map<ProcessTypeEnum, HashMap<ManagementHandler, Integer>> processTypeEnumHashMapMap = new ConcurrentHashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ManagementHandler) {
            ProcessType annotation = AnnotationUtils.findAnnotation(bean.getClass(), ProcessType.class);
            /**
             * 当bean为代理类（比如该类中有@Transactional注解）时，.getAnnotation(DateType.class)返回null
             * 而AnnotationUtils.findAnnotation(bean.getClass(), DateType.class)可以解决这个问题
             */
//            ProcessType annotation = bean.getClass().getAnnotation(ProcessType.class);
            if (Objects.nonNull(annotation)) {
                ProcessTypeEnum[] enums = annotation.value();
                int sort = annotation.sort();
                for (ProcessTypeEnum anEnum : enums) {
                    if (processTypeEnumHashMapMap.containsKey(anEnum)) {
                        HashMap<ManagementHandler, Integer> map = processTypeEnumHashMapMap.get(anEnum);
                        if (!map.containsKey(bean)) {
                            map.put((ManagementHandler) bean, sort);
                        }
                    } else {
                        HashMap<ManagementHandler, Integer> map = new HashMap<>();
                        map.put((ManagementHandler) bean, sort);
                        processTypeEnumHashMapMap.put(anEnum, map);
                    }
                }
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    public List<ManagementHandler> getService(ProcessTypeEnum processTypeEnum) {
        HashMap<ManagementHandler, Integer> map = this.processTypeEnumHashMapMap.get(processTypeEnum);
        ArrayList<Map.Entry<ManagementHandler, Integer>> entries = new ArrayList<>(map.entrySet());
        List<ManagementHandler> result = entries.stream().sorted(Map.Entry.comparingByValue()).map(Map.Entry::getKey).collect(Collectors.toList());
        return result;
    }
}
