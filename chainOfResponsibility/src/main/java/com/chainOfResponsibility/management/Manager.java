package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 经理
 */
@Component
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff, ProcessTypeEnum.Resignation}, sort = 2)
public class Manager implements ManagementHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("2 - Manager - 经理 - 处理该申请");
    }
}
