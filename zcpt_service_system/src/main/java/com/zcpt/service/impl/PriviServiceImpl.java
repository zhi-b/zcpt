package com.zcpt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zcpt.mapper.PrivilegeMapper;
import com.zcpt.system.IPrivilegeService;
import com.zcpt.pojo.system.Privilege;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class PriviServiceImpl implements IPrivilegeService {
    @Autowired
    private PrivilegeMapper privilegeMapper;
    @Override
    public List<Privilege> findPriviList() {
        return privilegeMapper.selectList(null);
    }

    @Override
    public Integer addPrivi(Privilege privilege) {
        return privilegeMapper.insert(privilege);
    }

    @Override
    public Integer updatePrivi(Privilege privilege) {
        return privilegeMapper.updateById(privilege);
    }

    @Override
    public Integer deletePriviById(Integer id) {
        return privilegeMapper.deleteById(id);
    }
}
