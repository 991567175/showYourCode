package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import com.chainOfResponsibility.handler.ProcessHandler;

/**
 * 经理
 */
@ProcessType(value = {ProcessTypeEnum.OnBoarding, ProcessTypeEnum.RegularStaff, ProcessTypeEnum.Resignation}, sort = 2)
public class Manager implements ProcessHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("Manager - 经理 - 处理该申请");
    }
}
