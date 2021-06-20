package com.hans.mall;

import com.hans.mall.dao.CategoryMapper;
import com.hans.mall.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
//        Category category = categoryMapper.findById(100001);
//        System.out.println(category.toString());
    }

    @Test
    public void queryByIdTest(){
//        Category category = categoryMapper.queryById(100001);
//        System.out.println(category.toString());
    }

}
