package com.hans.mall.form;


import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterForm {

    @NotBlank(message = "Usrname not empty") // for string
    // @NotEmpty for collection
    // @NotNull for integer
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
