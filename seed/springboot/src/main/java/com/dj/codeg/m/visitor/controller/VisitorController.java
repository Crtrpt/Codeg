package com.dj.codeg.m.visitor.controller;

import com.dj.codeg.system.utils.ResultDto;
import com.dj.codeg.system.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.dj.codeg.m.visitor.form.VisitorDto;
import com.dj.codeg.m.visitor.form.VisitorForm;
import com.dj.codeg.m.visitor.form.VisitorListDto;
import com.dj.codeg.m.visitor.form.VisitorQuery;
import com.dj.codeg.m.visitor.service.VisitorService;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/visitor")
public class VisitorController {

    @Autowired
    VisitorService visitorService;

    @ApiOperation(value = "测试模块列表")
    @GetMapping("/list")
    public ResultDto<List<VisitorListDto>> index(VisitorQuery query){
        return ResultDto.OK(visitorService.list(query));
    }

    @ApiOperation(value = "测试模块编辑")
    @PostMapping("/edit")
    public ResultDto<VisitorDto> edit(@RequestBody VisitorForm form){
        var source=visitorService.save(form);
        var target=new VisitorDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "增加测试模块")
    @PostMapping("/add")
    public ResultDto<VisitorDto> add(@RequestBody VisitorForm form){
        var source=visitorService.create(form);
        var target=new VisitorDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "测试模块删除")
    @PostMapping("/delete")
    public ResultDto<Boolean> delete( @RequestParam(name="id") String id){
        return ResultDto.OK(visitorService.delete(id));
    }
}