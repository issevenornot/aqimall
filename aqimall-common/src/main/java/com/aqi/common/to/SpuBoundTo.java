package com.aqi.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author koi
 * @Date 2022/5/11 20:00
 * @Version 1.0
 */
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;

//    public SpuBoundTo() {
//    }
//
//    public SpuBoundTo(Long spuId, BigDecimal buyBounds, BigDecimal growBounds) {
//        this.spuId = spuId;
//        this.buyBounds = buyBounds;
//        this.growBounds = growBounds;
//    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public BigDecimal getBuyBounds() {
        return buyBounds;
    }

    public void setBuyBounds(BigDecimal buyBounds) {
        this.buyBounds = buyBounds;
    }

    public BigDecimal getGrowBounds() {
        return growBounds;
    }

    public void setGrowBounds(BigDecimal growBounds) {
        this.growBounds = growBounds;
    }
}
