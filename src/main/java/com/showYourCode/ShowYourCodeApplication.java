package com.showYourCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ShowYourCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowYourCodeApplication.class, args);
    }

}
