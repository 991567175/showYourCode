package com.showYourCode.cleanIfElse.useFactoryAndAnnotation;

import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.factory.DateTypeFactory;
import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.service.DateTypeOfMonthService;
import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.service.DateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class UseFactoryAndAnnotationTest {

    @Autowired
    private DateTypeFactory dateTypeFactory;
    @Autowired
    private DateTypeOfMonthService dateTypeOfMonthService;

    @Test
    void test1() {
        Integer dateType = 1;

        DateTypeService service = dateTypeFactory.getService(dateType);
        Date startTime = service.getStartTime();
        Date endTime = service.getEndTime();
        if (AopUtils.isAopProxy(service)) {
            log.info(service.toString());
        }
        if (AopUtils.isAopProxy(dateTypeOfMonthService)) {
            log.info(dateTypeOfMonthService.toString());
        }
        log.info(startTime.toString());
        log.info(endTime.toString());
    }
}
