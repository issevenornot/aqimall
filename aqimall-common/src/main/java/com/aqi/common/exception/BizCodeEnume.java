package com.aqi.common.exception;

/**
 * @Author koi
 * @Date 2022/4/19 16:44
 * @Version 1.0
 * 10001 代表商品格式异常等
 */
public enum BizCodeEnume {
    //10001 代表商品格式异常等
    UNKNOWN_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式检验失败"),
    PRODUCT_UP_EXCEPTION(11000,"商品上架异常");
    private final int code;
    private final String msg;
    BizCodeEnume(int code,String msg){
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
