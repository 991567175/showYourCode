package com.usefactoryandannotation1;

import com.usefactoryandannotation1.factory.DateTypeFactory;
import com.usefactoryandannotation1.service.DateTypeOfMonthService;
import com.usefactoryandannotation1.service.DateTypeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class UseFactoryAndAnnotation1ApplicationTests {

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
        // dateTypeOfMonthService 类上有@Transactional注解，所以这里是一个代理对象
        if (AopUtils.isAopProxy(dateTypeOfMonthService)) {
            log.info(dateTypeOfMonthService.toString());
        }
        log.info(startTime.toString());
        log.info(endTime.toString());
    }
}
