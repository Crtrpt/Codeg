package com.dj.codeg.system.dto;

import lombok.Data;

@Data
public class UserBean {
    private String username;

    private String password;

    private String role;

    private String permission;
}
