package com.aqi.aqimail.product.feign;

import com.aqi.common.to.SkuHasStockVo;
import com.aqi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author koi
 * @Date 2022/5/24 11:39
 * @Version 1.0
 */
@FeignClient("aqimail-ware")
public interface WareFeignService {
    /**
     * 1、R设计的时候加上泛型
     * 2、直接返回我们想要的结果
     * 3、自己封装解析结果
     * */
    @PostMapping("/ware/waresku/hasstock")
    R getSkusHasStock(@RequestBody List<Long> skuIds);
}
