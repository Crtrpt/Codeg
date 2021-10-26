package com.dj.codeg.m.user.form;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value="ap对象", description="user")
public class UserDto {

    @ApiModelProperty(value = "主键id")
    String id;

    @ApiModelProperty(value = "名称")
    String name;
}