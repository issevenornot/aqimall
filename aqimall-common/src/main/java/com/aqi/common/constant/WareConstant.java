package com.aqi.common.constant;

/**
 * @Author koi
 * @Date 2022/5/16 15:50
 * @Version 1.0
 */
public class WareConstant {
    public enum PurchaseStatusEnum{
        /**
         * @Params Cr
         * */
        CREATED(0,"新建"),ASSIGNED(1,"已分配"),RECEIVE(2,"已领取")
        ,FINISHED(3,"已完成"),HASERROR(4,"有异常");
        private int code;
        private String msg;
        PurchaseStatusEnum(int code,String msg){
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

    public enum PurchaseDetailStatusEnum{
        /**
         * @Params Cr
         * */
        CREATED(0,"新建"),ASSIGNED(1,"已分配"),BUYING(2,"正在采购")
        ,FINISHED(3,"已完成"),HASERROR(4,"失败");
        private int code;
        private String msg;
        PurchaseDetailStatusEnum(int code,String msg){
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
