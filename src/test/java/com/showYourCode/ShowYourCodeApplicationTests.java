package com.showYourCode;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useEnum.DateTypeEnum;
import com.showYourCode.cleanIfElse.useFactory.DateTypeFactory1;
import com.showYourCode.cleanIfElse.useFactory.DateTypeFactory2;
import com.showYourCode.cleanIfElse.useFactory.DateTypeHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Objects;

@SpringBootTest
class ShowYourCodeApplicationTests {


    @Test
    void ifElse() {
        int a = 0;
        Date startTime = null;
        Date endTime = null;
        if (Objects.equals(a, DateTypeEnum.MONTH.getCode())) {
            startTime = DateUtil.beginOfMonth(DateUtil.date());
            endTime = DateUtil.endOfMonth(DateUtil.date());
        } else if (Objects.equals(a, DateTypeEnum.QUARTER.getCode())) {
            startTime = DateUtil.beginOfQuarter(DateUtil.date());
            endTime = DateUtil.endOfQuarter(DateUtil.date());
        } else if (Objects.equals(a, DateTypeEnum.YEAR.getCode())) {
            startTime = DateUtil.beginOfYear(DateUtil.date());
            endTime = DateUtil.endOfYear(DateUtil.date());
        }
        System.out.println(startTime);
        System.out.println(endTime);
    }


    @Test
    void dateTypeEnum() {
        int a = 0;
        DateTypeEnum enumA = DateTypeEnum.getEnumByCode(a);
        if (Objects.isNull(enumA)) {
            throw new RuntimeException();
        }
        Date startTime = enumA.getStartTime();
        Date endTime = enumA.getEndTime();
        System.out.println(startTime);
        System.out.println(endTime);
    }

    @Autowired
    private DateTypeFactory1 dateTypeFactory1;

    @Test
    void dateTypeFactory1() {
        int a = 0;
        DateTypeHandler handler = dateTypeFactory1.getHandler(a);
        Date startTime = handler.getStartTime();
        Date endTime = handler.getEndTime();
        System.out.println(startTime);
        System.out.println(endTime);
    }


    @Autowired
    private DateTypeFactory2 dateTypeFactory2;

    @Test
    void dateTypeFactory2() {
        int a = 1;
        DateTypeHandler handler = dateTypeFactory2.getHandler(a);
        Date startTime = handler.getStartTime();
        Date endTime = handler.getEndTime();
        System.out.println(startTime);
        System.out.println(endTime);
    }

}
