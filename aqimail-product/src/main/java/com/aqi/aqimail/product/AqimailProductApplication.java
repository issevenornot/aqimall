package com.aqi.aqimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author koi
 * @Date 2022/4/11 20:49
 * @Version 1.0
 */
/**
 * 整合mybatis-plus
 * 1-导入依赖
 * 2-配置
 *  --配置数据源
 *  1、导入数据库驱动
 *  2、在application.yaml配置数据源相关信息
 *  --配置mybatis-plus
 *  1、使用MapperScan
 *  2、告诉mybatis-plus，sql映射文件位置
 * */
@MapperScan("com.aqi.aqimail.product.dao")
@SpringBootApplication
public class AqimailProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(AqimailProductApplication.class, args);
    }
}
