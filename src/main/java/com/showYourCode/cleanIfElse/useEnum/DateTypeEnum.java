package com.showYourCode.cleanIfElse.useEnum;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Objects;

public enum DateTypeEnum {
    MONTH(0, "月") {
        @Override
        public Date getStartTime() {
            return DateUtil.beginOfMonth(DateUtil.date());
        }

        @Override
        public Date getEndTime() {
            return DateUtil.endOfMonth(DateUtil.date());
        }
    },
    QUARTER(1, "季") {
        @Override
        public Date getStartTime() {
            return DateUtil.beginOfQuarter(DateUtil.date());
        }

        @Override
        public Date getEndTime() {
            return DateUtil.endOfQuarter(DateUtil.date());

        }
    },
    YEAR(2, "年") {
        @Override
        public Date getStartTime() {
            return DateUtil.beginOfYear(DateUtil.date());
        }

        @Override
        public Date getEndTime() {
            return DateUtil.endOfYear(DateUtil.date());

        }
    },
    ;

    private final Integer code;
    private final String desc;

    public abstract Date getStartTime();

    public abstract Date getEndTime();

    DateTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static DateTypeEnum getEnumByCode(Integer code) {
        for (DateTypeEnum value : DateTypeEnum.values()) {
            if (Objects.equals(value.code, code)) {
                return value;
            }
        }
        return null;
    }
}
