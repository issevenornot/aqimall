package com.aqi.aqimail.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Author koi
 * @Date 2022/5/29 21:31
 * @Version 1.0
 */
@Configuration
public class MyRedissonConfig {
    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson() {
        //创建配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.56.10:6379");
        //创建RedissonClient实例
        return Redisson.create(config);
    }
}
