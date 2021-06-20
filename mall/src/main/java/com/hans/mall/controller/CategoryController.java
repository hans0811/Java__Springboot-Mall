package com.hans.mall.controller;

import com.hans.mall.pojo.Category;
import com.hans.mall.service.impl.CategoryServiceImpl;
import com.hans.mall.vo.CategoryVo;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;


    @GetMapping("/categories")
    public ResponseVo<List<CategoryVo>> selectAll() {

        return categoryService.selectAll();

    }


}
