package ${package_name}.${module_name}.controller;

import ${system_package}.system.utils.ResultDto;
import ${system_package}.system.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;

import ${package_name}.${module_name}.form.${filename}Dto;
import ${package_name}.${module_name}.form.${filename}Form;
import ${package_name}.${module_name}.form.${filename}ListDto;
import ${package_name}.${module_name}.form.${filename}Query;
import ${package_name}.${module_name}.service.${filename}Service;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "${display_name}")
@RestController
@RequestMapping("${request_path_prefix}${name}")
public class ${filename}Controller {

    @Autowired
    ${filename}Service ${name}Service;

    @ApiOperation(value = "${display_name}列表")
    @GetMapping("/list")
    public ResultDto<List<${filename}ListDto>> index(${filename}Query query){
        return ResultDto.OK(${name}Service.list(query));
    }

    @ApiOperation(value = "${display_name}编辑")
    @PostMapping("/edit")
    public ResultDto<${filename}Dto> edit(@RequestBody ${filename}Form form){
        var source=${name}Service.save(form);
        var target=new ${filename}Dto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "增加${display_name}")
    @PostMapping("/add")
    public ResultDto<${filename}Dto> add(@RequestBody ${filename}Form form){
        var source=${name}Service.create(form);
        var target=new ${filename}Dto();
        BeanUtils.copyProperties(source,target);
        return ResultDto.OK(target);
    }

    @ApiOperation(value = "${display_name}删除")
    @PostMapping("/delete")
    public ResultDto<Boolean> delete( @RequestParam(name="id") String id){
        return ResultDto.OK(${name}Service.delete(id));
    }
}