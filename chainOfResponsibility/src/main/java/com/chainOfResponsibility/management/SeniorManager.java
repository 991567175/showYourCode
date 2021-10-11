package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 资深经理
 */
@Component
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff}, sort = 3)
public class SeniorManager implements ManagementHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("3 - SeniorManager - 资深经理 - 处理该申请");
    }
}
