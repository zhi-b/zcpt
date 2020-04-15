package com.zcpt.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zcpt.entity.ResponseData;
import com.zcpt.pojo.system.Role;
import com.zcpt.system.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/role")
@Api(tags = "角色管理")
public class RoleController {
    @Reference
    private IRoleService roleService;
    @GetMapping("/findRole")
    @ApiOperation(value = "查找角色" , notes = "根据角色id查找角色")
    @ApiImplicitParam(value = "角色id" , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Role> findRoleById(Integer id){
        Role role = roleService.findRoleById(id);
        if(role != null){
            return ResponseData.success().putDataVule("role" , role);
        }
        return  ResponseData.serverInternalError();
    }
    @GetMapping("/roleList")
    @ApiOperation(value = "查找所有角色" , notes = "查找所有角色")
    public ResponseData<Role> findRoles(){
        List<Role> roleList = roleService.findAllRole();
        if(roleList != null){
            return ResponseData.success().putDataVule("roleList" , roleList);
        }
        return  ResponseData.serverInternalError();
    }
    @GetMapping("/deleteRole")
    @ApiOperation(value = "删除角色" , notes = "根据ID删除角色")
    @ApiImplicitParam(value = "待删除的角色id" , name = "id" , required = true , dataType = "Integer" , paramType = "query")
    public ResponseData<Role> deleteRoleById(Integer id){
        Integer integer = roleService.deleteRole(id);
        if(integer == 1){
            return ResponseData.success().putDataVule("deleteRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/updateRole")
    @ApiOperation(value = "更新角色" , notes = "修改角色信息")
    @ApiImplicitParam(value = "修改后的角色对象" , name = "role" , required = true , dataType = "Role" , paramType = "body")
    public ResponseData<Role> updateRole(@RequestBody Role role){
        Integer integer = roleService.updateRole(role);
        if(integer == 1){
            return ResponseData.success().putDataVule("updateRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
    @PostMapping("/insertRole")
    @ApiOperation(value = "添加角色" , notes = "添加新的角色（属性：name , introduction）")
    @ApiImplicitParam(value = "要添加角色对象" , name = "role" , required = true , dataType = "Role" , paramType = "body")
    public ResponseData<Role> insertRole(@RequestBody Role role){
        Integer integer = roleService.insertRole(role);
        if(integer == 1){
            return ResponseData.success().putDataVule("insertRes" , integer);
        }
        return ResponseData.serverInternalError();
    }
}
