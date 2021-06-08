package com.showYourCode.cleanIfElse.useFactory.handler;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useFactory.DateTypeHandler;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateTypeOfYearHandler implements DateTypeHandler {
    @Override
    public Date getStartTime() {
        return DateUtil.beginOfYear(DateUtil.date());
    }

    @Override
    public Date getEndTime() {
        return DateUtil.endOfYear(DateUtil.date());
    }
}
