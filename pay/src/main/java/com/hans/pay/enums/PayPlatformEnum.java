package com.hans.pay.enums;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import lombok.Getter;

@Getter
public enum PayPlatformEnum {

    // 1-alipay, 2-wx-pay
    ALIPAY(1),
    WX(2),
    ;

    Integer code;

    PayPlatformEnum(Integer code){
        this.code = code;
    }

    public static PayPlatformEnum getByBestPayTypeEnum(BestPayTypeEnum bestPayTypeEnum) {

        for (PayPlatformEnum payPlatformEnum : PayPlatformEnum.values()) {
            if (bestPayTypeEnum.getPlatform().name().equals(payPlatformEnum.name())){
                return payPlatformEnum;
            }
        }
        throw new RuntimeException("Not support: " + bestPayTypeEnum.name());
    };
}
