package ${package_name}.${module_name}.form;

import ${system_package}.system.utils.ResultDto;
import ${system_package}.system.Page;
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
@ApiModel(value="${name}列表", description="${name}列表")
public class ${filename}ListDto {

    @ApiModelProperty(value = "主键id")
    String id;

    @ApiModelProperty(value = "名称")
    String name;
}