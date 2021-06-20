package com.hans.mall.service.impl;

import com.hans.mall.dao.UserMapper;
import com.hans.mall.enums.ResponseEnum;
import com.hans.mall.enums.RoleEnum;
import com.hans.mall.pojo.User;
import com.hans.mall.service.IUserService;
import com.hans.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.hans.mall.enums.ResponseEnum.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> register(User user) {

        //error();

        // user name not repeated
        int countByUseranme = userMapper.countByUsername(user.getUsername());

        if ( countByUseranme > 0 ) {
            // throw new RuntimeException("Username already exited");
            return ResponseVo.error(USERNAME_EXIST);
        }

        // email not repeated
        // user name not repeated
        int countByEmail = userMapper.countByEmail(user.getEmail());

        if ( countByEmail > 0 ) {
            return ResponseVo.error(EMAIL_EXIST);
        }

        // Normal register
        user.setRole(RoleEnum.CUSTOMER.getCode());

        // MD5
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
        ));

        // write to db
        int resultCount = userMapper.insertSelective(user);
        if( resultCount == 0 ) {
            return ResponseVo.error(ERROR);
        }

        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);

        if ( user == null) {
            // user not exist
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))) {
            // password wrong
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }

        user.setPassword("");
        return ResponseVo.success(user);
    }

    private void error(){
        throw new RuntimeException("error");
    }
}
