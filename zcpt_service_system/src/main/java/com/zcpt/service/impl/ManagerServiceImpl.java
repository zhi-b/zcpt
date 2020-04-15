package com.zcpt.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.ManagerMapper;
import com.zcpt.pojo.system.Manager;
import com.zcpt.system.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class ManagerServiceImpl implements IManagerService {
   @Autowired
   private ManagerMapper managerMapper;
    @Override
    public List<Manager> findManager() {
        return managerMapper.selectList(null);
    }

    @Override
    public List<Manager> findManagerByCondition(Map<String , Object> queryMap) {
        QueryWrapper<Manager> queryWrapper = null;
        if(queryMap != null){
            queryWrapper = new QueryWrapper();
            if(!StringUtils.isEmpty(queryMap.get("username"))){
                queryWrapper.like("username" , queryMap.get("username"));
            }
            if(!StringUtils.isEmpty(queryMap.get("roleId"))){
                queryWrapper.eq("role_id" , queryMap.get("roleId"));
            }
        }
        return managerMapper.selectList(queryWrapper);
    }

    @Override
    public Manager getManagerByName(String name) {
        return managerMapper.selectOne(new QueryWrapper<Manager>()
                                        .eq("username" , name));
    }

    @Override
    public Integer updateManager(Manager manager) {
        return managerMapper.updateById(manager);
    }

    @Override
    public Integer deleteMangerById(Integer id) {
        return managerMapper.deleteById(id);
    }

    @Override
    public Integer insertManger(Manager manager) {
        String hashpw = BCrypt.hashpw(manager.getPassword(), BCrypt.gensalt());
        manager.setPassword(hashpw);
        return managerMapper.insert(manager);
    }
}
