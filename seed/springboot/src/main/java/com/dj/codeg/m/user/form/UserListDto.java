package com.dj.codeg.m.user.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value="user列表", description="user列表")
public class UserListDto {

    @ApiModelProperty(value = "主键id")
    String id;

    @ApiModelProperty(value = "名称")
    String name;
}