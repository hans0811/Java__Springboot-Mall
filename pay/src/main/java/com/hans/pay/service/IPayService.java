package com.hans.pay.service;

import com.hans.pay.pojo.PayInfo;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

public interface IPayService {

    /**
     * create payment
     * @param orderId
     * @param amount
     * @return
     */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    /**
     * async
     * @param notifyData
     */
    String asyncNotify(String notifyData);

    /**
     * payment record(through orderId)
     * @param orderId
     * @return
     */
    PayInfo queryByOrderId(String orderId);
}
