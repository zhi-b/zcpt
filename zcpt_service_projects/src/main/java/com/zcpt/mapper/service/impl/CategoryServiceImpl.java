package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.CategoryMapper;
import com.zcpt.mapper.ProjectMapper;
import com.zcpt.pojo.projects.Category;
import com.zcpt.projects.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Integer findByName(Map<String, Object> queryMap) {
        return categoryMapper.selectOne(new QueryWrapper<Category>().eq("pro_category", queryMap.get("category"))).getId();
    }
}
