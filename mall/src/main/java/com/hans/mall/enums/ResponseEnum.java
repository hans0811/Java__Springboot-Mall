package com.hans.mall.enums;


import lombok.Getter;

@Getter
public enum ResponseEnum {

    ERROR(-1, "server error"),

    SUCCESS(0, "Success"),

    PASSWORD_ERROR(1, "password error"),

    USERNAME_EXIST(2, "user exist"),

    PARAM_ERROR(3, "PARAM error"),

    EMAIL_EXIST(4, "user exist"),

    NEED_LOGIN(10, "not login"),

    USERNAME_OR_PASSWORD_ERROR(11, "username or password wrong"),

    PRODUCT_OFF_SALE_OR_DELETE(12, "Item not exist")
    ;

    Integer code;
    String  desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
