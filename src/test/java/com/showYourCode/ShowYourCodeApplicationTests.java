package com.showYourCode;

import com.showYourCode.unknow.Work1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Objects;

@SpringBootTest
class ShowYourCodeApplicationTests {

//    @Resource
//    public void setWork1(Work1 work1) {
//        this.work1 = work1;
//    }

//    @Autowired
//    public ShowYourCodeApplicationTests(Work1 work1) {
//        this.work1 = work1;
//    }

        @Autowired(required = false)
    private Work1 work1;

    @Test
    void test1() {
        if (Objects.isNull(work1)) {
            System.out.println("work1 is null");
        } else {
            System.out.println("work1 is not null");
        }
    }

}
