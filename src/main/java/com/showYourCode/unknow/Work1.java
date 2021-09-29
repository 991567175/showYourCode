package com.showYourCode.unknow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Work1 implements Worker {
    @Autowired
    private  Work2 work2;



    @Override
    public void skill() {

    }
}
