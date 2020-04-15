package com.zcpt.realname;

import com.zcpt.pojo.users.Realname;

import java.util.List;
import java.util.Map;

/**
 * 添加实名信息记录
 */
public interface IRealNameService {
    //插入实名信息
    void addRealName(Map<String,Object> map);
    //通过id更改审核状态
    void modifyRealName(Integer id);
    //展示详情给后台管理员
    List<Realname> realnameList();
}
