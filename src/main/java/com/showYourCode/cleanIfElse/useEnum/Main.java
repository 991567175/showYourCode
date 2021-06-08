package com.showYourCode.cleanIfElse.useEnum;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        int a = 0;
        Date startTime = null;
        Date endTime = null;

        // 垃圾的代码
//        if (Objects.equals(a, DateTypeEnum.MONTH.getCode())) {
//            startTime = DateUtil.beginOfMonth(DateUtil.date());
//            endTime = DateUtil.endOfMonth(DateUtil.date());
//        } else if (Objects.equals(a, DateTypeEnum.QUARTER.getCode())) {
//            startTime = DateUtil.beginOfQuarter(DateUtil.date());
//            endTime = DateUtil.endOfQuarter(DateUtil.date());
//        } else if (Objects.equals(a, DateTypeEnum.YEAR.getCode())) {
//            startTime = DateUtil.beginOfYear(DateUtil.date());
//            endTime = DateUtil.endOfYear(DateUtil.date());
//        }


        // 优雅的代码
        DateTypeEnum enumA = DateTypeEnum.getEnumByCode(a);
        startTime = enumA.getStartTime();
        endTime = enumA.getEndTime();

    }


}
