package com.hans.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hans.mall.dao.ProductMapper;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.pojo.Product;
import com.hans.mall.service.ICategoryService;
import com.hans.mall.service.IProductService;
import com.hans.mall.vo.ProductDetailVo;
import com.hans.mall.vo.ProductVo;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hans.mall.enums.ProductStatusEnum.DELETE;
import static com.hans.mall.enums.ProductStatusEnum.OFF_SALE;
import static com.hans.mall.enums.ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if (categoryId != null){
            categoryService.findSubCategoryId(categoryId, categoryIdSet);
            // Add self to the set
            categoryIdSet.add(categoryId);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.selectByCategoryIdSet(categoryIdSet);
        List<ProductVo> productVoList = productList.stream()
                .map(e -> {
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e, productVo);
                    return productVo;
                })
                .collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo<>(productList);
        pageInfo.setList(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetailVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        if (product.getStatus().equals(OFF_SALE.getCode()) || product.getStatus().equals(DELETE.getCode())){
            return ResponseVo.error(PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetailVo productDetailVo = new ProductDetailVo();
        BeanUtils.copyProperties(product, productDetailVo);
        productDetailVo.setStock(product.getStock() > 100 ? 100: product.getStock());
        return ResponseVo.success(productDetailVo);
    }
}
