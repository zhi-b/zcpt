package com.zcpt.system;

import com.zcpt.pojo.system.Privilege;

import java.util.List;

public interface IPrivilegeService {

    List<Privilege> findPriviList();

    Integer addPrivi(Privilege privilege);

    Integer updatePrivi(Privilege privilege);

    Integer deletePriviById(Integer id);
}
