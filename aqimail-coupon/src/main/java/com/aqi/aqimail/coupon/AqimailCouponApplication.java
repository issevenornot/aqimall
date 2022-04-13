package com.aqi.aqimail.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AqimailCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(AqimailCouponApplication.class, args);
    }

}
