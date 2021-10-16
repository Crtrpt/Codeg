package ${package_name}.${module_name}.entity;

import ${system_package}.system.BaseEntity;
import ${system_package}.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.Data;
import io.swagger.annotations.ApiModel;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@SQLDelete(sql = "update `${name}` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "${name}")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@ApiModel(value="${display_name}", description="${display_name}")
public class ${filename}Entity extends BaseEntity implements Serializable {
    @Id
    String id;

    String name;
}