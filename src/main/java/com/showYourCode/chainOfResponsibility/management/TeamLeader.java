package com.showYourCode.chainOfResponsibility.management;

import com.showYourCode.chainOfResponsibility.annotation.ProcessType;
import com.showYourCode.chainOfResponsibility.enums.ProcessTypeEnum;
import com.showYourCode.chainOfResponsibility.handler.ProcessHandler;

/**
 * 组长
 */
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff, ProcessTypeEnum.Resignation, ProcessTypeEnum.Leave}, sort = 1)
public class TeamLeader implements ProcessHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("TeamLeader - 组长 - 处理该申请");
    }
}
