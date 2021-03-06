package com.usefactoryandannotation1.service;

import cn.hutool.core.date.DateUtil;
import com.usefactoryandannotation1.annotation.DateType;
import com.usefactoryandannotation1.enums.DateTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
@Component
@DateType(DateTypeEnum.MONTH)
@Transactional
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
