package com.useEnums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class UseEnumsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UseEnumsApplication.class, args);
    }

}
