package com.chainOfResponsibility.management;

import com.chainOfResponsibility.annotation.ProcessType;
import com.chainOfResponsibility.enums.ProcessTypeEnum;
import com.chainOfResponsibility.handler.ProcessHandler;

/**
 * 总监
 */
@ProcessType(value = {ProcessTypeEnum.OnBoarding}, sort = 4)
public class Director implements ProcessHandler {
    @Override
    public void execute(Integer processType) {
        System.out.println("Director - 总监 - 处理该申请");
    }
}
