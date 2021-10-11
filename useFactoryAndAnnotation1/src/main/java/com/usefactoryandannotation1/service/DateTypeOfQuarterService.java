package com.usefactoryandannotation1.service;

import cn.hutool.core.date.DateUtil;
import com.usefactoryandannotation1.annotation.DateType;
import com.usefactoryandannotation1.enums.DateTypeEnum;
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
