package com.showYourCode.cleanIfElse.useFactoryAndAnnotation.service;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useEnum.DateTypeEnum;
import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.annotation.DateType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@DateType(DateTypeEnum.QUARTER)
public class DateTypeOfQuarterService implements DateTypeService {
    @Override
    public Date getStartTime() {
        return DateUtil.beginOfQuarter(DateUtil.date());
    }

    @Override
    public Date getEndTime() {
        return DateUtil.endOfQuarter(DateUtil.date());
    }
}
