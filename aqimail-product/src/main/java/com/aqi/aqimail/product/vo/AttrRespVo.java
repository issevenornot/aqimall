package com.aqi.aqimail.product.vo;

import lombok.Data;

/**
 * @Author koi
 * @Date 2022/4/23 20:33
 * @Version 1.0
 */
@Data
public class AttrRespVo extends AttrVo{
    /**
     *所属分类的名字 “手机/数码/手机”
     * */
    private String catelogName;
    /**
     *所属分组的名字
     * */
    private String groupName;
    //属性信息
    private Long[] catelogPath;
}
