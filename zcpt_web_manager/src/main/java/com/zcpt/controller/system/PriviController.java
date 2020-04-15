package com.zcpt.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.system.Privilege;
import com.zcpt.system.IPrivilegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/privilege")
@Api(tags = "权限列表管理")
public class PriviController {
    @Reference
    private IPrivilegeService privilegeService;
    @GetMapping("/priviList")
    @ApiOperation(value = "获取所有权限" , notes = "查询所有权限")
    public ResponseData<Privilege> findPriviList(){
        List<Privilege> priviList = privilegeService.findPriviList();
        if(priviList != null){
            return ResponseData.success().putDataVule("priviList" , priviList);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/insertPrivi")
    @ApiOperation(value = "要添加的权限" , notes = "要添加的权限对象 属性：name ， status")
    @ApiImplicitParam(value = "要添加的权限" , name = "privilege" , required = true , dataType = "Privilege" , paramType = "body")
    public ResponseData<Privilege> insertPrivi(@RequestBody Privilege privilege){
        Integer integer = privilegeService.addPrivi(privilege);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/updatePrivi")
    @ApiOperation(value = "要更新的权限" , notes = "修改之后的权限对象 属性：name , status")
    @ApiImplicitParam(value = "要添加的权限" , name = "privilege" , required = true , dataType = "Privilege" , paramType = "body")
    public ResponseData<Privilege> updatePrivi(@RequestBody Privilege privilege){
        Integer integer = privilegeService.updatePrivi(privilege);
        if(integer == 1){
            return ResponseData.success().putDataVule("updateRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @GetMapping("/deletePrivi")
    @ApiOperation(value = "删除权限" , notes = "根据权限id删除权限")
    @ApiImplicitParam(value = "要删除的权限id"  , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Privilege> deletePrivi(Integer id){
        Integer integer = privilegeService.deletePriviById(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
}
