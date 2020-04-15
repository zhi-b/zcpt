package com.zcpt.controller.projects;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.pojo.projects.Collection;
import com.zcpt.pojo.projects.Project;
import com.zcpt.projects.ICollectionService;
import com.zcpt.projects.IProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/collectionlogin")
public class CollectionController {
    @Reference
    private ICollectionService collectionService;
    @Reference
    private IProjectService projectService;
    @GetMapping("/myColPro")
    private String findMyColPro(HttpServletRequest request){
        String id = request.getParameter("id");
        List<Project> projectList = new ArrayList<>();
        List<Collection> collectionList = collectionService.findCollectionByUserId(Integer.parseInt(id));
        for(Collection collection : collectionList){
            Project project = projectService.findProById(collection.getProjectId());
            projectList.add(project);
        }
        System.out.println(projectList);
        return "";
    }
}
