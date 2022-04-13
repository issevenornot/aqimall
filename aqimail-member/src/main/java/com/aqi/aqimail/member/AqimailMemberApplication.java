package com.aqi.aqimail.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 一、想要远程调用的别的服务的步骤
 *   1、引入open-feign
 *   2、编写一个接口，告诉springcloud这个接口需要调用远程服务
 *    --声明接口的每一个方法都是调用哪个远程服务的哪个请求
 *   3、开启远程调用功能
 * */
@EnableFeignClients(basePackages = "com.aqi.aqimail.member.feign")//扫描此包下所有的接口
@SpringBootApplication
@EnableDiscoveryClient
public class AqimailMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(AqimailMemberApplication.class, args);
    }

}
