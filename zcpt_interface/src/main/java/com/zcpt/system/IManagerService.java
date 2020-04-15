package com.zcpt.system;

import com.zcpt.pojo.system.Manager;

import java.util.List;
import java.util.Map;


public interface IManagerService {
    List<Manager> findManager();

    List<Manager> findManagerByCondition(Map<String, Object> queryMap);

    Manager getManagerByName(String name);

    Integer updateManager(Manager manager);

    Integer deleteMangerById(Integer id);
//
    Integer insertManger(Manager manager);
}
