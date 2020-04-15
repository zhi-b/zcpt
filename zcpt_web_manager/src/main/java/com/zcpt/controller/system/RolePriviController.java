package com.zcpt.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.system.RolePrivi;
import com.zcpt.system.IRolePriviService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system/rolePrivi")
@Api(tags = "权限管理")
public class RolePriviController {
    @Reference
    private IRolePriviService rolePriviService;
    @PostMapping("/insertRP")
    @ApiOperation(value = "给角色添加权限" , notes = "给某个角色添加权限")
    @ApiImplicitParam(value = "要添加的角色权限信息" , name = "rolePrivi" , required = true , dataType = "RolePrivi" , paramType = "body")
    public ResponseData<RolePrivi> insertRP(@RequestBody RolePrivi rolePrivi){
        Integer integer = rolePriviService.InsertRolePrivi(rolePrivi);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @GetMapping("/deleteRP")
    @ApiOperation(value = "给角色删除权限" , notes = "给某个角色删除权限")
    @ApiImplicitParam(value = "要删除权限的对应role_privi的id" , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<RolePrivi> deleteRP(Integer id){
        Integer integer = rolePriviService.deleteRPById(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/updateRP")
    @ApiOperation(value = "给角色修改权限" , notes = "给某个角色修改权限")
    @ApiImplicitParam(value = "要修改的角色与权限" , name = "rolePrivi" , required = true , dataType = "RolePrivi" , paramType = "body")
    public ResponseData<RolePrivi> updateRP(@RequestBody RolePrivi rolePrivi){
        Integer integer = rolePriviService.updateRolePrivi(rolePrivi);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
}
