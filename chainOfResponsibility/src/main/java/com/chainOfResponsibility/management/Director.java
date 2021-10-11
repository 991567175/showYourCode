package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 总监
 */
@Component
@ProcessType(value = {ProcessTypeEnum.OnBoarding}, sort = 4)
public class Director implements ManagementHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("4 - Director - 总监 - 处理该申请");
    }
}
