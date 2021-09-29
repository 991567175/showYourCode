package com.showYourCode.chainOfResponsibility.management;

import com.showYourCode.chainOfResponsibility.annotation.ProcessType;
import com.showYourCode.chainOfResponsibility.enums.ProcessTypeEnum;
import com.showYourCode.chainOfResponsibility.handler.ProcessHandler;

/**
 * 资深经理
 */
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff}, sort = 3)
public class SeniorManager implements ProcessHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("SeniorManager - 资深经理 - 处理该申请");
    }
}
