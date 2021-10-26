package ${package_name}.${module_name}.service;

import ${system_package}.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import ${package_name}.${module_name}.form.${filename}Dto;
import ${package_name}.${module_name}.form.${filename}Form;
import ${package_name}.${module_name}.form.${filename}ListDto;
import ${package_name}.${module_name}.form.${filename}Query;
import ${package_name}.${module_name}.service.${filename}Service;
import ${package_name}.${module_name}.entity.${filename}Entity;


import java.util.ArrayList;
import java.util.List;


public interface ${filename}Service {
    /**
     * 获取${display_name}列表
     */
    public List<${filename}ListDto> list(${filename}Query query);

    /**
     * 保存${display_name}信息
     */
    public ${filename}Entity save(${filename}Form form);

    /**
     * 创建${display_name}信息
     */
    public ${filename}Entity create(${filename}Form form);

    /**
     * 删除${display_name}
     */
    public Boolean delete(String id);
}