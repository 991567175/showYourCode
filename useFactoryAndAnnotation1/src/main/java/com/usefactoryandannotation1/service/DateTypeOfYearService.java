package com.usefactoryandannotation1.service;

import cn.hutool.core.date.DateUtil;
import com.usefactoryandannotation1.annotation.DateType;
import com.usefactoryandannotation1.enums.DateTypeEnum;
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
