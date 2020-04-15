package com.zcpt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.IRoleMapper;
import com.zcpt.mapper.PrivilegeMapper;
import com.zcpt.mapper.RolePriviMapper;
import com.zcpt.system.IRoleService;
import com.zcpt.pojo.system.Privilege;
import com.zcpt.pojo.system.Role;
import com.zcpt.pojo.system.RolePrivi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleMapper roleMapper;
    @Autowired
    private RolePriviMapper rolePriviMapper;
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Override
    public Role findRoleById(Integer id) {
        Role role = roleMapper.selectById(id);
        return addPrivi(role);
    }

    @Override
    public List<Role> findAllRole() {
        List<Role> roleList = roleMapper.selectList(null);
        for(Role role : roleList){
            role = addPrivi(role);
        }
        return roleList;
    }

    @Override
    public Integer updateRole(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public Integer deleteRole(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public Integer insertRole(Role role) {
        return roleMapper.insert(role);
    }
    private Role addPrivi(Role role){
        List<Privilege> privilegeList = new ArrayList<>();
        List<RolePrivi> rolePriviList = rolePriviMapper.selectList(new QueryWrapper<RolePrivi>().eq("r_id", role.getId()));
        for(RolePrivi rolePrivi : rolePriviList){
            privilegeList.add(privilegeMapper.selectOne(new QueryWrapper<Privilege>().eq("id" , rolePrivi.getPId())));
        }
        role.setPrivilegeList(privilegeList);
        return role;
    }
}
