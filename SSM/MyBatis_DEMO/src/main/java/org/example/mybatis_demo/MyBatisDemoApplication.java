package org.example.mybatis_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan  // 开启对servlet的支持
@SpringBootApplication
public class MyBatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisDemoApplication.class, args);
    }

}
