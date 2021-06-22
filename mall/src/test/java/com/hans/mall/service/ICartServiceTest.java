package com.hans.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.form.CartAddForm;
import com.hans.mall.form.CartUpdateForm;
import com.hans.mall.pojo.Cart;
import com.hans.mall.service.impl.CartServiceImpl;
import com.hans.mall.vo.CartVo;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ICartServiceTest {

    @Autowired
    private CartServiceImpl cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private Integer uid = 1;

    private Integer productId = 26;

    @Test
    void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(29);
        form.setSelected(true);
        ResponseVo<CartVo> responseVo = cartService.add(1, form);
        log.info("list={}", gson.toJson(responseVo));
    }

    @Test
    public void test() {
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void update() {
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(10);
        ResponseVo<CartVo> responseVo = cartService.update(1, 26, form);
        log.info("result={}", gson.toJson(responseVo));

    }

    @Test
    public void delete() {
        ResponseVo<CartVo> responseVo = cartService.delete(1, 27);
        log.info("result={}", gson.toJson(responseVo));
    }

    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(uid);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }

    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(uid);
        log.info("result={}", gson.toJson(responseVo));
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }


}