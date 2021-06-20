package com.hans.mall;

import com.hans.mall.consts.MallConst;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.exception.UserLoginException;
import com.hans.mall.pojo.User;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle...,{}", request);

        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if( user == null) {
             log.info("user = null");
             throw new UserLoginException();
            //return false;
            //return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return true;
    }
}
