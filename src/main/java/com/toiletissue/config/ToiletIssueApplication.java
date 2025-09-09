package com.toiletissue.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.toiletissue")
@MapperScan(basePackages = "com.toiletissue", annotationClass = Mapper.class)
public class ToiletIssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToiletIssueApplication.class, args);
    }

}
