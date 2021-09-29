package com.showYourCode.chainOfResponsibility.management;

import com.showYourCode.chainOfResponsibility.annotation.ProcessType;
import com.showYourCode.chainOfResponsibility.enums.ProcessTypeEnum;
import com.showYourCode.chainOfResponsibility.handler.ProcessHandler;

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
