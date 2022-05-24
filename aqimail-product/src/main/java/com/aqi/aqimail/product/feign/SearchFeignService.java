package com.aqi.aqimail.product.feign;

import com.aqi.common.to.es.SkuEsModel;
import com.aqi.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author koi
 * @Date 2022/5/24 13:14
 * @Version 1.0
 */
@FeignClient("aqimail-search")
public interface SearchFeignService {
    @PostMapping("/search/save/product")
    R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
