package com.example.demospring00;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaServer
@SpringBootApplication
public class DemoSpring00Application {

    public static void main(String[] args) {
        System.out.println("hello world!");
        SpringApplication.run(DemoSpring00Application.class, args);
    }

}
