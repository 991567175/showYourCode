package com.showYourCode.unknow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Work2 implements Worker {
    @Autowired
    private Work1 work1;

//    public Work2(Work1 work1) {
//        this.work1 = work1;
//    }

    @Override
    public void skill() {

    }
}
