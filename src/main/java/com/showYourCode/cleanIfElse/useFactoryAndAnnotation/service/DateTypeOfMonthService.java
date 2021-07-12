package com.showYourCode.cleanIfElse.useFactoryAndAnnotation.service;

import cn.hutool.core.date.DateUtil;
import com.showYourCode.cleanIfElse.useEnum.DateTypeEnum;
import com.showYourCode.cleanIfElse.useFactoryAndAnnotation.annotation.DateType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@DateType(DateTypeEnum.MONTH)
public class DateTypeOfMonthService implements DateTypeService {
    @Override
    public Date getStartTime() {
        return DateUtil.beginOfMonth(DateUtil.date());
    }

    @Override
    public Date getEndTime() {
        return DateUtil.endOfMonth(DateUtil.date());
    }

}
