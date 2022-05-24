package com.aqi.common.to;

import lombok.Data;

/**
 * @Author koi
 * @Date 2022/5/24 11:26
 * @Version 1.0
 */
@Data
public class SkuHasStockVo {
    private Long skuId;
    private Boolean hasStock;
}
