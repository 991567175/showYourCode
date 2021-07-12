package com.showYourCode.cleanIfElse.useEnum;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Objects;

@SpringBootTest
@Slf4j
public class UseEnumTest {

    @Test
    void test1(){
        Integer dateType = 1;

        DateTypeEnum dateTypeEnum = DateTypeEnum.getEnumByCode(dateType);
        if (Objects.isNull(dateTypeEnum)) {
            throw new RuntimeException();
        }
        Date startTime = dateTypeEnum.getStartTime();
        Date endTime = dateTypeEnum.getEndTime();
        log.info(startTime.toString());
        log.info(endTime.toString());
    }
}
