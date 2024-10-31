package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 加载配置文件：通过 @ImportResource 注解，Spring 框架会从指定的类路径中加载 spring.xml 配置文件。
 * 初始化Spring上下文：加载完成后，Spring 会根据配置文件中的定义初始化相应的 Bean 和配置。
 */
@ImportResource("classpath*:config/spring.xml")
//@EnableSwagger2
@SpringBootApplication
public class DemoSpring00Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpring00Application.class, args);
    }

}
