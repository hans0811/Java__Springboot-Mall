package com.hans.mall.service;

import com.github.pagehelper.PageInfo;
import com.hans.mall.vo.ProductDetailVo;
import com.hans.mall.vo.ProductVo;
import com.hans.mall.vo.ResponseVo;

import java.util.List;

public interface IProductService {

    ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

    ResponseVo<ProductDetailVo> detail(Integer productId);
}
