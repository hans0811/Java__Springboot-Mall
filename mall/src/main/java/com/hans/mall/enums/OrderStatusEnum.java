package com.hans.mall.enums;


import lombok.Getter;

/**
 * order status: 0 - cancel, 10-unpaid, 20- paid, 40 - shiping, 50 - success, 60 - close
 */
@Getter
public enum OrderStatusEnum {

    CANCELED(0, "Cancel"),
    NO_PAY(10, "Unpaid"),
    PAID(20, "Paid"),
    SHIPPED(40, "Shipping"),
    TRADE_SUCCESS(50, "Success"),
    TRADE_CLOSE(60, "Close"),
    ;

    Integer code;
    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
