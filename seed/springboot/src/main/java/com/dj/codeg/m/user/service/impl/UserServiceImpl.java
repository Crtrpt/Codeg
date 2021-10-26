package com.dj.codeg.m.user.service.impl;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.dj.codeg.m.user.service.UserService;
import com.dj.codeg.m.user.form.UserDto;
import com.dj.codeg.m.user.form.UserForm;
import com.dj.codeg.m.user.form.UserListDto;
import com.dj.codeg.m.user.form.UserQuery;
import com.dj.codeg.m.user.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Data
public class UserServiceImpl   implements UserService {


    /**
     * 获取用户信息列表
     */
    public List<UserListDto> list(UserQuery query){
        return null;
    }

    /**
     * 保存用户信息信息
     */
    public UserEntity save(UserForm form){
        return null;
    }

    /**
     * 创建用户信息信息
     */
    public UserEntity create(UserForm form){
        return null;
    }

    /**
     * 删除用户信息
     */
    public Boolean delete(String id){
        return null;
    }
}