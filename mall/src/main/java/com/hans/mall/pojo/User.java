package com.hans.mall.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private Integer id;

    public User(String username, String password, String email, Integer role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role  = role;
    }

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;


}