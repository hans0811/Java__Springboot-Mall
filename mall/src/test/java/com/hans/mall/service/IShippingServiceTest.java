package com.hans.mall.service;

import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.form.ShippingForm;
import com.hans.mall.pojo.Shipping;
import com.hans.mall.service.impl.ShippingServiceImpl;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class IShippingServiceTest {

    @Autowired
    private ShippingServiceImpl shippingService;

    private Integer uid = 1;

    private ShippingForm form;

    private Integer shippingId = 7;

    @BeforeEach
    public void before() {
        ShippingForm form = new ShippingForm();
        form.setReceiverName("JohnDon");
        form.setReceiverAddress("SiderBar");
        form.setReceiverCity("Taipei");
        form.setReceiverMobile("123456789");
        form.setReceiverPhone("01234567");
        form.setReceiverProvince("Taiwan");
        form.setReceiverDistrict("Taipei");
        form.setReceiverZip("20621");
        this.form = form;
    }

    @Test
    void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void delete() {
        Integer shippingId = 6;
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void update() {
        form.setReceiverCity("Kaoshon");
        ResponseVo responseVo = shippingService.update(uid, shippingId, form );
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    void list() {
        ResponseVo responseVo =shippingService.list(uid, 1, 10);
        log.info("result={}", responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}