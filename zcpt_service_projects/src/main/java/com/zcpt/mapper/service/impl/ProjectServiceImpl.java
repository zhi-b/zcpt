package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcpt.mapper.CategoryMapper;
import com.zcpt.mapper.ProjectMapper;
import com.zcpt.pojo.projects.Project;
import com.zcpt.projects.ICategoryService;
import com.zcpt.projects.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ICategoryService categoryService;

    //首页：部分项目列表查询
//    @Override
//    public List<Project> projectList(Map<String,Object> queryMap) {
//        QueryWrapper queryWrapper = null;
//        if (queryMap != null){
//            queryWrapper = new QueryWrapper<>();
//            //根据产品类型名查询
//            if(!StringUtils.isEmpty(queryMap.get("category"))){
//                System.out.println("category不为空！");
//                //根据类型名获得类型id
//                Integer category_id = categoryService.findByName(queryMap);
//                queryWrapper.eq("category_id", category_id);
//            }
//            projectMapper.selectList(queryWrapper.last(true, "limit 4"));
//        }else {
//            return null;
//        }
//    }

    //根据条件查询
    @Override
    public IPage<Project> projectListByCondition(Integer pageNum, Integer pageSize, Map<String,Object> queryMap) {
        IPage<Project> page = new Page<>(pageNum,pageSize);
        projectMapper.selectPage(page, queryWrapper(queryMap));
        return page;
    }

    @Override
    public Integer insertPro(Project project) {
        return projectMapper.insert(project);
    }

    @Override
    public List<Project> findProByUserId(Integer userId) {
        return projectMapper.selectList(new QueryWrapper<Project>().eq("user_id" , userId));
    }

    @Override
    public Project findProById(Integer id) {
        return projectMapper.selectById(id);
    }


    private QueryWrapper<Project> queryWrapper(Map<String, Object> queryMap){
        QueryWrapper<Project> queryWrapper = null;
        if(queryMap != null){
            queryWrapper = new QueryWrapper<>();
            System.out.println("queryMap不为空！");
            //根据产品名字模糊查询
            if(!StringUtils.isEmpty(queryMap.get("name"))){
                System.out.println("name不为空！");
                queryWrapper.like("name", queryMap.get("name"));
            }
            //根据产品类型名查询
            if(!StringUtils.isEmpty(queryMap.get("category"))){
                System.out.println("category不为空！");
                //根据类型名获得类型id
                Integer category_id = categoryService.findByName(queryMap);
                queryWrapper.eq("category_id", category_id);
            }
            //根据时间、众筹金额最多、参与人数最多排序
            if(!StringUtils.isEmpty(queryMap.get("sort"))){
                System.out.println("sort不为空！");
                String sort_name =(String) queryMap.get("sort");
                //根据时间
                if (sort_name.equals("time")){
                    queryWrapper.orderByDesc("created");
                }
                //根据众筹金额降序
                if (sort_name.equals("money")){
                    queryWrapper.orderByDesc("money_total");
                }
                //根据支持人数降序
                if (sort_name.equals("people")){
                    queryWrapper.orderByDesc("number_support");
                }
            }
            //根据项目状态查找 0:未开始 1:正在进行 2:已完成
            if(!StringUtils.isEmpty(queryMap.get("status"))){
                System.out.println("status不为空！");
                queryWrapper.eq("status", queryMap.get("status"));
            }
        }
        return queryWrapper;
    }

}
