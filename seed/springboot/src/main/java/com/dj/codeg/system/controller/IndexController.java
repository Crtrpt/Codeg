package com.dj.codeg.system.controller;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "首页模块")
@RestController
public class IndexController {


    @ApiOperation(value = "用户没有登录返回的数据")
    @GetMapping("/401")
    public ResultDto<String> index() {
        return ResultDto.Error(10000, "当前页面需要授权");
    }
}