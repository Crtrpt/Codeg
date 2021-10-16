package com.dj.codeg.m.cgtest.service.impl;

import com.dj.codeg.system.utils.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.dj.codeg.m.cgtest.service.CgtestService;
import com.dj.codeg.m.cgtest.form.CgtestDto;
import com.dj.codeg.m.cgtest.form.CgtestForm;
import com.dj.codeg.m.cgtest.form.CgtestListDto;
import com.dj.codeg.m.cgtest.form.CgtestQuery;
import com.dj.codeg.m.cgtest.service.CgtestService;
import com.dj.codeg.m.cgtest.entity.CgtestEntity;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Data
public class CgtestServiceImpl   implements CgtestService {


    /**
     * 获取测试模块列表
     */
    public List<CgtestListDto> list(CgtestQuery query){
        return null;
    }

    /**
     * 保存测试模块信息
     */
    public CgtestEntity save(CgtestForm form){
        return null;
    }

    /**
     * 创建测试模块信息
     */
    public CgtestEntity create(CgtestForm form){
        return null;
    }

    /**
     * 删除测试模块
     */
    public Boolean delete(String id){
        return null;
    }
}