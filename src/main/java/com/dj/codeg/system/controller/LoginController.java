package com.dj.codeg.system.controller;

import com.dj.codeg.system.dto.UserBean;
import com.dj.codeg.system.config.JWTUtil;
import com.dj.codeg.system.service.UserService;
import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "登录模块")
@RestController
@Slf4j
public class LoginController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public ResultDto<String> login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        log.info("用户登录:"+username);
        UserBean userBean = userService.getUser(username);
        if (userBean.getPassword().equals(password)) {
            return  ResultDto.OK(JWTUtil.sign(username, password) );
        } else {
            return  ResultDto.Error(1,"登录异常");
        }
    }

    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public ResultDto<String> article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return ResultDto.OK("当前用户已经登录"+ JWTUtil.getUsername((String)subject.getPrincipal()));
        } else {
            return ResultDto.Error("登录用户没有登录");
        }
    }


}