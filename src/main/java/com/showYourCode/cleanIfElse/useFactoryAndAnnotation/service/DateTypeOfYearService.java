package com.showYourCode.cleanIfElse.useFactoryAndAnnotation.service;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useEnum.DateTypeEnum;
import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.annotation.DateType;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@DateType(DateTypeEnum.YEAR)
public class DateTypeOfYearService implements DateTypeService {
    @Override
    public Date getStartTime() {
        return DateUtil.beginOfYear(DateUtil.date());
    }

    @Override
    public Date getEndTime() {
        return DateUtil.endOfYear(DateUtil.date());
    }
}
