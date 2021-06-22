package com.hans.mall.controller;

import com.hans.mall.consts.MallConst;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.form.UserLoginForm;
import com.hans.mall.form.UserRegisterForm;
import com.hans.mall.pojo.User;
import com.hans.mall.service.impl.UserServiceImpl;
import com.hans.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Objects;

import static com.hans.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user/register")
    public ResponseVo register(@Valid @RequestBody UserRegisterForm userRegisterForm) {

//        if ( bindingResult.hasErrors() ) {
//            log.error("register error, {} {}",
//                    Objects.requireNonNull(bindingResult.getFieldError()).getField(),
//                    bindingResult.getFieldError().getDefaultMessage());
//            return ResponseVo.error(PARAM_ERROR, bindingResult);
//        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        // dto
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession session) {

        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());

        // Set session
        //HttpSession session = httpServletRequest.getSession();
        session.setAttribute( MallConst.CURRENT_USER, userResponseVo.getData());
        log.info("/login sessionId={}", session.getId());

        return userResponseVo;
    }

    // /user/ != /user
    // session into ram -> token + redis
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConst.CURRENT_USER);

//        if( user == null) {
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        }

        return ResponseVo.success(user);
    }

    // TODO log status, interceptor
    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session) {
        log.info("/user/logout sessionId={}", session.getId());

        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }

}
