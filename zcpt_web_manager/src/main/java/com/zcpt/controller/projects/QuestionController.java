package com.zcpt.controller.projects;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.projects.Question;
import com.zcpt.projects.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Api(tags = "问题管理")
public class QuestionController {
    @Reference
    private IQuestionService questionService;
    @GetMapping("/queList")
    @ApiOperation(value = "获取某项目的问题" ,notes = "根据项目id获取此项目问题")
    @ApiImplicitParam(value = "项目id", name = "proId" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Question> findQueList(Integer proId){
        List<Question> questionList = questionService.findQuestionByProId(proId);
        if(questionList != null){
            return ResponseData.success().putDataVule("questionList" , questionList);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/insertQue")
    @ApiOperation(value = "添加新的问题" , notes = "添加新的问题对象")
    @ApiImplicitParam(value = "要添加的新问题" , name = "question" , required = true , dataType = "Question" , paramType = "body")
    public ResponseData<Question> addQue(@RequestBody Question question){
        Integer integer = questionService.insertQuestion(question);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @GetMapping("/deleteQue")
    @ApiOperation(value = "删除问题" , notes = "根据id删除问题")
    @ApiImplicitParam(value = "要删除的问题id" , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Question> deleteQuestion(Integer id){
        Integer integer = questionService.deleteQuestion(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
}
