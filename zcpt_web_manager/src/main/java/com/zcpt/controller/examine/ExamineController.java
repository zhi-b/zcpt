package com.zcpt.controller.examine;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.users.Realname;
import com.zcpt.realname.IRealNameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "审核接口")
@RestController
@RequestMapping("/examine")
public class ExamineController {
    @Reference
    private IRealNameService realNameService;

    //审核实名认证信息,展示详情
    @GetMapping("/realnameList")
    @ApiOperation(value = "待审核实名信息列表", notes = "获取待审核实名信息")
    public ResponseData<Realname> realnameList(){
        List<Realname> realnameList = realNameService.realnameList();
        if (realnameList != null){
            return ResponseData.success().putDataVule("realnameList", realnameList);
        }
        return ResponseData.serverInternalError();
    }


    //修改实名状态为1:通过
    @PostMapping("/realnamePass")
    @ApiOperation(value = "实名通过验证", notes = "修改对应id的实名id的状态为通过")
    @ApiImplicitParam(value = "实名表id" ,name = "realnameId",required = true,dataType = "Integer",paramType = "query")
    public ResponseData<Realname> realnamePass(@RequestParam Integer realnameId){
        if(realnameId != null){
            realNameService.modifyRealName(realnameId);
            return ResponseData.success().putDataVule("successDes", realnameId);
        }else {
            return ResponseData.serverInternalError();
        }
    }
}
