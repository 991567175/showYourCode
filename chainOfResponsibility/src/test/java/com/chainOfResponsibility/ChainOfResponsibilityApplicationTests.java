package com.chainOfResponsibility;

import com.chainOfResponsibility.bbp.ManagementBeanPostProcessor;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import com.chainOfResponsibility.management.ManagementHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ChainOfResponsibilityApplicationTests {

    @Autowired
    private ManagementBeanPostProcessor managementBeanPostProcessor;

    @Test
    void contextLoads() {

        ProcessTypeEnum processTypeEnum = ProcessTypeEnum.OnBoarding;
        System.out.println("开始" + processTypeEnum.getDesc() + "流程");
        List<ManagementHandler> service = managementBeanPostProcessor.getService(processTypeEnum);
        service.forEach(it -> it.execute(processTypeEnum.getCode()));
    }

}
