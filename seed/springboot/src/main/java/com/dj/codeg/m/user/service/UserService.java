package com.dj.codeg.m.user.service;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import com.dj.codeg.m.user.form.UserDto;
import com.dj.codeg.m.user.form.UserForm;
import com.dj.codeg.m.user.form.UserListDto;
import com.dj.codeg.m.user.form.UserQuery;
import com.dj.codeg.m.user.service.UserService;
import com.dj.codeg.m.user.entity.UserEntity;


import java.util.ArrayList;
import java.util.List;


public interface UserService {
    /**
     * 获取用户信息列表
     */
    public List<UserListDto> list(UserQuery query);

    /**
     * 保存用户信息信息
     */
    public UserEntity save(UserForm form);

    /**
     * 创建用户信息信息
     */
    public UserEntity create(UserForm form);

    /**
     * 删除用户信息
     */
    public Boolean delete(String id);
}