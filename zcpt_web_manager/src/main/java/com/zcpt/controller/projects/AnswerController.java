package com.zcpt.controller.projects;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.projects.Answer;
import com.zcpt.projects.IAnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
@Api(tags = "回答信息管理")
public class AnswerController {
    @Reference
    private IAnswerService answerService;
    @PostMapping("/insertAns")
    @ApiOperation(value ="要添加的回答" , notes = "添加新的回答")
    @ApiImplicitParam(value = "新的回答对象" , name = "answer" , required = true , dataType = "Answer" , paramType = "body")
    public ResponseData<Answer> addAnswer(@RequestBody Answer answer){
        Integer integer = answerService.insertAnswer(answer);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @GetMapping("/deleteAns")
    @ApiOperation(value ="要删除的回答" , notes = "根据id删除回答")
    @ApiImplicitParam(value = "要删除的回答id" , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Answer> deleteAnswer(Integer id){
        Integer integer = answerService.deleteAnswer(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
}
