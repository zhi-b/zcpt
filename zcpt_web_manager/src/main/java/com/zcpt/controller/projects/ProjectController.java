package com.zcpt.controller.projects;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.pojo.projects.Project;
import com.zcpt.projects.IProjectService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/projectlogin")
@Api(tags = "发起众筹")
public class ProjectController {

    @Reference
    private IProjectService projectService;
//    @PostMapping("/insertPro")
//    public String insertPro(HttpRequest request){

//        Integer integer = projectService.insertPro(project);
//        if(integer == 1){
//            return "success";
//        }
//        return "error";
//    }
    @GetMapping("/myPro")
    public String findProById(Model model , HttpServletRequest request){
        String id = request.getParameter("id");
        List<Project> projectList = projectService.findProByUserId(Integer.parseInt(id));
        System.out.println(projectList);
        if(projectList == null){
            return "";
        }
        return " ";
    }
}
