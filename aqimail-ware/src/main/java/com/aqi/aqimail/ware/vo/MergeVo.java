package com.aqi.aqimail.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author koi
 * @Date 2022/5/16 15:42
 * @Version 1.0
 */
@Data
public class MergeVo {
    private Long purchaseId;
    private List<Long> items;
}
