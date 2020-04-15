package com.zcpt.controller.projects;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zcpt.pojo.projects.Project;
import com.zcpt.projects.IProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Api(tags = "项目信息管理接口")
@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Reference
    private IProjectService projectService;

    // 项目总览：按需查询
    @GetMapping("/projectQuery")
    @ApiOperation(value = "条件分页查询项目列表",notes = "根据条件查询项目列表信息")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "当前页数",name = "pagenum",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "每页条数",name = "pagesize",required = false,dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(value = "查询条件",name = "queryMap",required = false,dataType = "Map",paramType = "body")
    })
    public String projectListQuery(Model model, @RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestBody Map<String,Object> queryMap){
        IPage<Project> projectPage = projectService.projectListByCondition(pageNum, pageSize, queryMap);
        model.addAttribute("totalnum", projectPage.getTotal());
        model.addAttribute("totalpage",projectPage.getPages());
        model.addAttribute("projectList", projectPage.getRecords());
        return "";
    }

    //首页部分项目展示
    @GetMapping("/projectQuerySome")
    @ApiOperation(value = "首页部分项目列表",notes = "根据条件查询项目列表信息")
    @ApiImplicitParam(value = "查询条件",name = "queryMap",required = false,dataType = "Map",paramType = "body")
    public String projectListSome(Model model,@RequestBody Map<String,Object> queryMap){
        IPage<Project> projectPage = projectService.projectListByCondition(1, 4, queryMap);
        model.addAttribute("projectList", projectPage.getRecords());
        return "";
    }
}
