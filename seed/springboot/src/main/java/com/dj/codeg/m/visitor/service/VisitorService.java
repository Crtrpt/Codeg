package com.dj.codeg.m.visitor.service;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import com.dj.codeg.m.visitor.form.VisitorDto;
import com.dj.codeg.m.visitor.form.VisitorForm;
import com.dj.codeg.m.visitor.form.VisitorListDto;
import com.dj.codeg.m.visitor.form.VisitorQuery;
import com.dj.codeg.m.visitor.service.VisitorService;
import com.dj.codeg.m.visitor.entity.VisitorEntity;


import java.util.ArrayList;
import java.util.List;


public interface VisitorService {
    /**
     * 获取测试模块列表
     */
    public List<VisitorListDto> list(VisitorQuery query);

    /**
     * 保存测试模块信息
     */
    public VisitorEntity save(VisitorForm form);

    /**
     * 创建测试模块信息
     */
    public VisitorEntity create(VisitorForm form);

    /**
     * 删除测试模块
     */
    public Boolean delete(String id);
}