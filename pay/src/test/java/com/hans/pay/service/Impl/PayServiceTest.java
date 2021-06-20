package com.hans.pay.service.Impl;

import com.hans.pay.PayApplication;
import com.hans.pay.PayApplicationTests;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        // BigDecimal.valueOf(0.01)
        // new BigDecimal(0.01)X -> new BigDecimal("0.01")
        payService.create("123445454334", BigDecimal.valueOf(0.01), BestPayTypeEnum.WXPAY_NATIVE);
    }
}