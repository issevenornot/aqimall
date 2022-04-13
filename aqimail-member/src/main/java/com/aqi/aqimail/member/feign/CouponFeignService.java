package com.aqi.aqimail.member.feign;

import com.aqi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author koi
 * @Date 2022/4/12 20:36
 * @Version 1.0
 */
@FeignClient("aqimail-coupon")//告诉springcloud这个接口是一个远程客户端
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
