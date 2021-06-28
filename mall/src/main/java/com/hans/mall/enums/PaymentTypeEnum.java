package com.hans.mall.enums;

import lombok.Getter;

@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
