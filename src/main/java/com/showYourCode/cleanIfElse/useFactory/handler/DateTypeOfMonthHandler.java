package com.showYourCode.cleanIfElse.useFactory.handler;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useFactory.DateTypeHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTypeOfMonthHandler implements DateTypeHandler {
    @Override
    public Date getStartTime() {
        return DateUtil.beginOfMonth(DateUtil.date());
    }

    @Override
    public Date getEndTime() {
        return DateUtil.endOfMonth(DateUtil.date());
    }
}
