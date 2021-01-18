package com.hulianpai.ordersys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hulianpai.ordersys.infrastructure.dao")
@SpringBootApplication
public class OrderSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSysApplication.class, args);
    }

}
