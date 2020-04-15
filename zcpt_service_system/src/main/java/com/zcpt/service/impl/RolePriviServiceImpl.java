package com.zcpt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zcpt.mapper.RolePriviMapper;
import com.zcpt.system.IRolePriviService;
import com.zcpt.pojo.system.RolePrivi;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RolePriviServiceImpl implements IRolePriviService {
    @Autowired
    private RolePriviMapper rolePriviMapper;
    @Override
    public Integer InsertRolePrivi(RolePrivi rolePrivi) {
        return rolePriviMapper.insert(rolePrivi);
    }

    @Override
    public Integer deleteRPById(Integer id) {
        return rolePriviMapper.deleteById(id);
    }

    @Override
    public Integer updateRolePrivi(RolePrivi rolePrivi) {
        return rolePriviMapper.updateById(rolePrivi);
    }
}
