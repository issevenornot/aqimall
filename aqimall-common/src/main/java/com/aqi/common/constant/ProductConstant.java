package com.aqi.common.constant;

/**
 * @Author koi
 * @Date 2022/4/24 20:19
 * @Version 1.0
 */
public class ProductConstant {
    public enum AttrEnum{
        //属性常量
        ATTR_TYPE_BASE(1,"基本属性"),ATTR_TYPE_SALE(0,"销售属性");
        private final int code;
        private final String msg;
        AttrEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
    public enum StatusEnum{
        //状态常量
        NEW_SPU(0,"新建"),SPU_UP(1,"商品上架"),SPU_DOWN(2,"商品下架");
        private final int code;
        private final String msg;
        StatusEnum(int code,String msg){
            this.code = code;
            this.msg = msg;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
