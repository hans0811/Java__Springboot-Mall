package com.hans.mall.dao;

import com.hans.mall.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryMapperTest {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void findById() {
//        Category category = categoryMapper.findById(100001);
//        System.out.println(category.toString());
    }

    @Test
    void queryById() {
//        Category category = categoryMapper.queryById(100001);
//        System.out.println(category.toString());
    }
}
