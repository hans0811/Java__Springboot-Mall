package com.hans.mall.service;

import com.github.pagehelper.PageInfo;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.pojo.Product;
import com.hans.mall.service.impl.ProductServiceImpl;
import com.hans.mall.vo.ProductDetailVo;
import com.hans.mall.vo.ProductVo;
import com.hans.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class IProductServiceTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void list() {
        // productService.list(100002, 1, 1);
        ResponseVo<PageInfo> responseVo = productService.list(null, 2, 2);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());

    }

    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}