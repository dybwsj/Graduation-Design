package com.dongruan.graduation.networkdiskcoreservice.config;

/**
 * @author: duyubo
 * @date: 2020年11月24日, 0024 11:24
 * @description: MyBatis相关配置
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.dongruan.graduation.networkdiskcoreservice.dao")
public class MybatisConfig {
}

