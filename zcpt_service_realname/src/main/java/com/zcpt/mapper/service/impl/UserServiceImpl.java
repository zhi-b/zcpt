package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zcpt.mapper.UserMapper;
import com.zcpt.realname.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    //修改user中的is_realname_check状态
    @Override
    public void modifyUserStatus(Integer id) {

    }
}
