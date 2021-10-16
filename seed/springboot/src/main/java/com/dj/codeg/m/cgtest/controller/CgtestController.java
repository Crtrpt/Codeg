package com.dj.codeg.m.cgtest.controller;

import com.dj.codeg.system.utils.ResultDto;
import com.dj.codeg.system.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import com.dj.codeg.m.cgtest.form.CgtestDto;
import com.dj.codeg.m.cgtest.form.CgtestForm;
import com.dj.codeg.m.cgtest.form.CgtestListDto;
import com.dj.codeg.m.cgtest.form.CgtestQuery;
import com.dj.codeg.m.cgtest.service.CgtestService;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "测试模块")
@RestController
@RequestMapping("/cgtest")
public class CgtestController {

    @Autowired
    CgtestService cgtestService;

    @ApiOperation(value = "测试模块列表")
    @GetMapping("/list")
    public ResultDto<List<CgtestListDto>> index(CgtestQuery query){
        return ResultDto.OK(cgtestService.list(query));
    }

    @ApiOperation(value = "测试模块编辑")
    @PostMapping("/edit")
    public ResultDto<CgtestDto> edit(@RequestBody CgtestForm form){
        var source=cgtestService.save(form);
        var target=new CgtestDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "增加测试模块")
    @PostMapping("/add")
    public ResultDto<CgtestDto> add(@RequestBody CgtestForm form){
        var source=cgtestService.create(form);
        var target=new CgtestDto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "测试模块删除")
    @PostMapping("/delete")
    public ResultDto<Boolean> delete( @RequestParam(name="id") String id){
        return ResultDto.OK(cgtestService.delete(id));
    }
}