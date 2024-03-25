package com.myblog.myblog22.payload;

import lombok.Data;

@Data
public class LoginDto {

    private String usernameOrEmail;

    private String password;
}
