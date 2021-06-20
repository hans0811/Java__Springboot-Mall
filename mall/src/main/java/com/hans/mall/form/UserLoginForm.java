package com.hans.mall.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    @NotBlank(message = "Usrname not empty") // for string
    private String username;

    @NotBlank
    private String password;
}
