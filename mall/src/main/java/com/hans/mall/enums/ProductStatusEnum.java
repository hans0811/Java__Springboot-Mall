package com.hans.mall.enums;


import lombok.Getter;

/**
 * 1-on sale, 2- discontinued, 3-delete
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1),
    OFF_SALE(2),
    DELETE(3),
    ;

    Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
