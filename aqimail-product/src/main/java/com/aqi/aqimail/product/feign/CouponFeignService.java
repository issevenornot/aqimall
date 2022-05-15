package com.aqi.aqimail.product.feign;

import com.aqi.common.to.SkuReductionTo;
import com.aqi.common.to.SpuBoundTo;
import com.aqi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author koi
 * @Date 2022/5/11 19:53
 * @Version 1.0
 * 从网页获取数据后，一个服务给另一个服务传数据
 * CouponFeignService.saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo)
 *  --@RequestBody将这个对象转为json
 *  --找到aqimail-coupon服务，给/coupon/spubounds/save发送请求，将上一步转的json放在请求体位置，发送请求
 *  --对方服务收到请求，请求体里有json数据@RequestBody SpuBoundsEntity spuBounds 将请求体的json转为SpuBoundsEntity对象，只需保证属性名一致
 *  只要json数据模型是兼容的，双方服务无需同一个to
 */
@FeignClient("aqimail-coupon")
public interface CouponFeignService {
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
