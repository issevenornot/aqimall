package com.aqi.aqimail.product.vo;

import com.aqi.aqimail.product.entity.AttrEntity;
import lombok.Data;

import java.util.List;

/**
 * @Author koi
 * @Date 2022/4/29 20:37
 * @Version 1.0
 */
@Data
public class AttrGroupWithAttrsVo {
    /**
     * 分组id
     */
    private Long attrGroupId;
    /**
     * 组名
     */
    private String attrGroupName;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String descript;
    /**
     * 组图标
     */
    private String icon;
    /**
     * 所属分类id
     */
    private Long catelogId;
    /**
     * 所有信息
     */
    private List<AttrEntity> attrs;
}
