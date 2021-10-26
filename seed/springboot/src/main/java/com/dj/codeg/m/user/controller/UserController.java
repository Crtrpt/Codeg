package com.dj.codeg.m.user.controller;

import com.dj.codeg.system.utils.ResultDto;
import com.dj.codeg.system.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.dj.codeg.m.user.form.UserDto;
import com.dj.codeg.m.user.form.UserForm;
import com.dj.codeg.m.user.form.UserListDto;
import com.dj.codeg.m.user.form.UserQuery;
import com.dj.codeg.m.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "用户信息")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "用户信息列表")
    @GetMapping("/list")
    public ResultDto<List<UserListDto>> index(UserQuery query){
        return ResultDto.OK(userService.list(query));
    }

    @ApiOperation(value = "用户信息编辑")
    @PostMapping("/edit")
    public ResultDto<UserDto> edit(@RequestBody UserForm form){
        var source=userService.save(form);
        var target=new UserDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "增加用户信息")
    @PostMapping("/add")
    public ResultDto<UserDto> add(@RequestBody UserForm form){
        var source=userService.create(form);
        var target=new UserDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "用户信息删除")
    @PostMapping("/delete")
    public ResultDto<Boolean> delete( @RequestParam(name="id") String id){
        return ResultDto.OK(userService.delete(id));
    }
}