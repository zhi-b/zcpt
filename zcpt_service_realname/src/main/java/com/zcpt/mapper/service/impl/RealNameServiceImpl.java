package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.RealNameMapper;
import com.zcpt.mapper.UserMapper;
import com.zcpt.pojo.users.Realname;
import com.zcpt.realname.IRealNameService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service
public class RealNameServiceImpl implements IRealNameService {
    @Autowired
    private RealNameMapper realNameMapper;

    @Autowired
    private UserMapper userMapper;

    //添加实名信息记录
    @Override
    public void addRealName(Map<String,Object> realNameMap) {
        Realname realname = new Realname();
        realname.setRealname((String)realNameMap.get("realname"));
        realname.setIdcard((String)realNameMap.get("idcard"));
        realname.setEmail((String)realNameMap.get("email"));
        realname.setPhone((String)realNameMap.get("phone"));
        realname.setImg((String)realNameMap.get("img"));
        realname.setIsPassCheck("0");
        realNameMapper.insert(realname);
    }

    //修改实名信息的is_pass_check状态为“1”：通过
    @Override
    public void modifyRealName(Integer id) {
        Realname realname = new Realname();
        realname.setId(id);
        realname.setIsPassCheck("1");
        realNameMapper.updateById(realname);
    }

    //展示详情给后台管理员
    @Override
    public List<Realname> realnameList() {
        List<Realname> realnameList = realNameMapper.selectList(
                new QueryWrapper<Realname>().eq("is_pass_check", 0));
        return realnameList;
    }
}
