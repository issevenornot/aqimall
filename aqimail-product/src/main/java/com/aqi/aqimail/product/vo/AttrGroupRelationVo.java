package com.aqi.aqimail.product.vo;

import lombok.Data;

/**
 * @Author koi
 * @Date 2022/4/24 20:52
 * @Version 1.0
 * 收集属性的id 和属性分组的id
 * [{"attrId":1,"attrGroupId":2}]
 */
@Data
public class AttrGroupRelationVo {
    private Long attrId;
    private Long attrGroupId;
}
