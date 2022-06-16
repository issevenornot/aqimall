package com.aqi.aqimail.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

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
 * 二、逻辑删除
 * 1、配置全局的逻辑删除规则
 *mybatis-plus:
 *   global-config:
 *     db-config:
 *       logic-delete-field: flag # 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略不配置步骤2)
 *       logic-delete-value: 1 # 逻辑已删除值(默认为 1)
 *       logic-not-delete-value: 0 # 逻辑未删除值(默认为 0)
 * 2、配置逻辑删除的组件@Bean（3.1.2之后跳过）
 *3: 实体类bean字段上加上@TableLogic注解
 * TableLogic
 * private Integer deleted;
 * */
@EnableCaching
@EnableFeignClients(basePackages = "com.aqi.aqimail.product.feign")
@MapperScan("com.aqi.aqimail.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class AqimailProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(AqimailProductApplication.class, args);
    }
}
