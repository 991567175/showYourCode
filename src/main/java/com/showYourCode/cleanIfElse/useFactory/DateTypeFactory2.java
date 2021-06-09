package com.showYourCode.cleanIfElse.useFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DateTypeFactory2 {

    @Autowired
    private ApplicationContext applicationContext;

    public DateTypeHandler getHandler(Integer dateTypeCode) {
        DateTypeFactory2Enum enumByCode = DateTypeFactory2Enum.getEnumByCode(dateTypeCode);
        if (Objects.isNull(enumByCode)) {
            throw new RuntimeException();
        }
        return applicationContext.getBean(enumByCode.getBeanName(), DateTypeHandler.class);
    }

    public enum DateTypeFactory2Enum {
        MONTH(0, "月", "dateTypeOfMonthHandler"),
        QUARTER(1, "季", "dateTypeOfQuarterHandler"),
        YEAR(2, "年", "dateTypeOfYearHandler"),
        ;


        private final Integer code;
        private final String desc;
        private final String beanName;

        DateTypeFactory2Enum(Integer code, String desc, String beanName) {
            this.code = code;
            this.desc = desc;
            this.beanName = beanName;
        }

        public static DateTypeFactory2Enum getEnumByCode(Integer code) {
            for (DateTypeFactory2Enum value : DateTypeFactory2Enum.values()) {
                if (Objects.equals(value.code, code)) {
                    return value;
                }
            }
            return null;
        }

        public Integer getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public String getBeanName() {
            return beanName;
        }
    }

}
