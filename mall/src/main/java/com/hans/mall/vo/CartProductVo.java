package com.hans.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {

    private Integer productId;

    private Integer quantity;

    private String productName;

    private Integer categoryId;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    private BigDecimal productTotalPrice;

    private Integer productStock;

    private Boolean productSelected;

}
