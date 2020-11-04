package com.common.generate.javacreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.common.generate.javacreate.dao"})
public class JavacreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavacreateApplication.class, args);
    }

}
