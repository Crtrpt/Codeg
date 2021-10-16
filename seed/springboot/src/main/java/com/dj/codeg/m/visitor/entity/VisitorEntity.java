package com.dj.codeg.m.visitor.entity;

import com.dj.codeg.system.BaseEntity;
import com.dj.codeg.system.utils.ResultDto;
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
@SQLDelete(sql = "update `visitor` SET deleted_at =  unix_timestamp(now()) WHERE id = ?")
@Entity
@Table(name = "visitor")
@Where(clause = "deleted_at is null")
@DynamicUpdate
@Cacheable
@ApiModel(value="测试模块", description="测试模块")
public class VisitorEntity extends BaseEntity implements Serializable {
    @Id
    String id;

    String name;
}