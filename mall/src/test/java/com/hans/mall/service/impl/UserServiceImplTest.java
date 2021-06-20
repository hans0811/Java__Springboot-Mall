package com.hans.mall.service.impl;

import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.enums.RoleEnum;
import com.hans.mall.pojo.User;
import com.hans.mall.service.IUserService;
import com.hans.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class UserServiceImplTest {

    public static final String USERNAME = "jack2";
    public static final String PASSWORD ="123456";

    @Autowired
    private UserServiceImpl userService;

    @BeforeEach //unit 5
    // @Before // unit 4
    public void register() {
        User user = new User(USERNAME, PASSWORD, "jack2@gmail.com", RoleEnum.CUSTOMER.getCode());
        userService.register(user);
    }

    @Test
    public void login() {
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }





}