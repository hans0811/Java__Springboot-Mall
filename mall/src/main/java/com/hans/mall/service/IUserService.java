package com.hans.mall.service;

import com.hans.mall.pojo.User;
import com.hans.mall.vo.ResponseVo;
import org.springframework.stereotype.Repository;


public interface IUserService {

    /**
     * Register
     */
    ResponseVo<User> register(User user);

    /**
     * Login
     *
     */
    ResponseVo<User> login(String username, String password);

}
