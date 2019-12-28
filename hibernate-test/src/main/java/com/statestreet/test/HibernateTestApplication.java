package com.statestreet.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateTestApplication {

    public static void main(String[] args) {
        SpringApplication springBootApp = new SpringApplication(HibernateTestApplication.class);
        springBootApp.run(args);
    }
}

