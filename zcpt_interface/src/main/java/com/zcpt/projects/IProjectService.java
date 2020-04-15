package com.zcpt.projects;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcpt.pojo.projects.Project;

import java.util.List;
import java.util.Map;

/**
 * 项目总览：按需查询项目
 */
public interface IProjectService {
    //部分项目信息列表
//    List<Project> projectList(Map<String,Object> queryMap);

    //根据条件查询
    IPage<Project> projectListByCondition(Integer pageNum, Integer pageSize, Map<String,Object> queryMap);

    //发起众筹
    Integer insertPro(Project project);

    //查看“我的众筹”
    List<Project> findProByUserId(Integer userId);

    //通过id查询项目：收藏夹
    Project findProById(Integer id);

}
