package com.dongruan.graduation.networkdiskfileservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@MapperScan(value = "com.dongruan.graduation.netwrokdiskfileservice.dao")
@SpringBootApplication
@EnableFeignClients
public class NetworkDiskFileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetworkDiskFileServiceApplication.class, args);
    }

}
