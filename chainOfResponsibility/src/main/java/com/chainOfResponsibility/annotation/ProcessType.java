package com.chainOfResponsibility.annotation;

import com.chainOfResponsibility.enums.ProcessTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessType {

    /**
     * 负责处理的流程类型
     * @return
     */
    ProcessTypeEnum[] value();

    /**
     * 处理流程顺序，0第一个处理
     * @return
     */
    int sort() default 0;

}
