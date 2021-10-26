package ${package_name}.${module_name}.form;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value="${name}查询", description="${name}查询")
public class ${filename}Query extends PageForm {

    @ApiModelProperty(value = "主键id")
    String id;

    @ApiModelProperty(value = "名称")
    String name;
}