package com.common.generate.javacreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.common.generate.javacreate.dao"})
public class JavacreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavacreateApplication.class, args);
    }

}
