package com.usefactoryandannotation1.annotation;

import com.usefactoryandannotation1.enums.DateTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateType {

    DateTypeEnum value();
}
