package com.chainOfResponsibility.enums;

import java.util.Objects;

public enum ProcessTypeEnum {
    OnBoarding(0, "入职流程"),
    RegularStaff(1, "转正流程"),
    Resignation(2, "离职流程"),
    Leave(3, "请假流程"),
    ;

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    ProcessTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static ProcessTypeEnum getEnumByCode(Integer code) {
        for (ProcessTypeEnum value : values()) {
            if (Objects.equals(value.code, code)) {
                return value;
            }
        }
        return null;
    }
}
