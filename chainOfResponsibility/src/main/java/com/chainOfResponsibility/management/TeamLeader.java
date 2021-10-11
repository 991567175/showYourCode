package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 组长
 */
@Component
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff, ProcessTypeEnum.Resignation, ProcessTypeEnum.Leave}, sort = 1)
public class TeamLeader implements ManagementHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("1 - TeamLeader - 组长 - 处理该申请");
    }
}
