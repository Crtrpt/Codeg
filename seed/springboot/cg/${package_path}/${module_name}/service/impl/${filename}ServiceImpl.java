package ${package_name}.${module_name}.service.impl;

import ${system_package}.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ${package_name}.${module_name}.service.${filename}Service;
import ${package_name}.${module_name}.form.${filename}Dto;
import ${package_name}.${module_name}.form.${filename}Form;
import ${package_name}.${module_name}.form.${filename}ListDto;
import ${package_name}.${module_name}.form.${filename}Query;
import ${package_name}.${module_name}.entity.${filename}Entity;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Data
public class ${filename}ServiceImpl   implements ${filename}Service {


    /**
     * 获取${display_name}列表
     */
    public List<${filename}ListDto> list(${filename}Query query){
        return null;
    }

    /**
     * 保存${display_name}信息
     */
    public ${filename}Entity save(${filename}Form form){
        return null;
    }

    /**
     * 创建${display_name}信息
     */
    public ${filename}Entity create(${filename}Form form){
        return null;
    }

    /**
     * 删除${display_name}
     */
    public Boolean delete(String id){
        return null;
    }
}