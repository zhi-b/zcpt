package com.zcpt.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.system.Manager;
import com.zcpt.system.IManagerService;
import com.zcpt.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/manager")
@Api(tags = "后台管理")
public class ManagerController {
    @Reference
    private IManagerService managerService;
    @GetMapping("/managerList")
    @ApiOperation(value = "后台管理员列表" , notes = "获取所有后台管理员")
    public ResponseData<Manager> findManagers(){
        List<Manager> managerList = managerService.findManager();
        if(managerList != null){
            return ResponseData.success().putDataVule("managerList" , managerList);
        }
        return ResponseData.serverInternalError();
    }
@PostMapping("/login")
@ApiOperation(value = "后台管理登录" , notes = "用户名和密码登录后台")
@ApiImplicitParams({
        @ApiImplicitParam(value = "用户名" , name = "username" , required = true , dataType = "String" , paramType = "query"),
        @ApiImplicitParam(value = "登录密码" , name = "password" , required = true , dataType = "String" , paramType = "query")
})
    public ResponseData<Manager> managerLogin(String username , String password){
        Manager manager = managerService.getManagerByName(username);
        ResponseData responseData = null;
        if(manager == null){
            responseData = ResponseData.cusstomerError("用户名不存在!");
        }else{
            boolean checkpw = BCrypt.checkpw(password, manager.getPassword());
            if(checkpw){
                String token = JWTUtils.generToken(manager.getId().toString(), "zcpt@mc", manager.getUsername());
                responseData = ResponseData.success().putDataVule("manager" , manager)
                                        .putDataVule("token" , token);
            }else{
                responseData= ResponseData.cusstomerError("密码错误！");
            }
        }
        return responseData;
    }
@PostMapping("/updateManager")
@ApiOperation(value = "更新管理员信息"  , notes = "修改管理员除id外的其他信息")
@ApiImplicitParam(value = "更新后的管理员对象" , name = "manager" , required = true ,dataType = "Manager" , paramType = "body")
    public ResponseData<Manager> updateManager(@RequestBody Manager manager){
        ResponseData responseData = null;
        Integer integer = managerService.updateManager(manager);
        if(integer == 1 ){
            responseData = ResponseData.success().putDataVule("updateRes" , integer);
        }else{
            responseData = ResponseData.serverInternalError();
        }
        return responseData;
    }
@PostMapping("/insertManager")
@ApiOperation(value = "添加新的管理员" , notes = "增加新的管理员")
@ApiImplicitParam(value = "新的管理员对象" , name = "manager" , required = true , dataType = "Manager"  , paramType = "body")
    public ResponseData<Manager> insertManager(@RequestBody Manager manager){

        Integer integer = managerService.insertManger(manager);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }else{
            return ResponseData.serverInternalError();
        }
    }
    @PostMapping("/deleteManager")
    @ApiOperation(value = "删除管理员" , notes = "根据ID删除管理员")
    @ApiImplicitParam(value = "要删除的管理员ID" , name = "id" , required = true , dataType = "Integer"  , paramType = "query")
    public ResponseData<Manager> deleteManager(Integer id){
        Integer integer = managerService.deleteMangerById(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }else{
            return ResponseData.serverInternalError();
        }
    }
    @PostMapping("/managerList")
    @ApiOperation(value = "条件查询" , notes = "根据管理员名和角色ID查询")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "查询条件" , name = "queryMap" , required = false , dataType = "Map" , paramType = "body")
    })
    public ResponseData<Manager> findManagersByCondition(@RequestBody Map<String , Object> queryMap){
        List<Manager> managerList = managerService.findManagerByCondition(queryMap);
        if(managerList == null){
            return ResponseData.serverInternalError();
        }else{
            return ResponseData.success().putDataVule("managerList" , managerList);
        }
    }


}
