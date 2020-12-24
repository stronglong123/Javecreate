package com.common.generate.javacreate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@EnableTransactionManagement
@MapperScan(basePackages = {"com.common.generate.javacreate.dao"})
public class JavacreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavacreateApplication.class, args);
    }

}
