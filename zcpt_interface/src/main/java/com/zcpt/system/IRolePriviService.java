package com.zcpt.system;


import com.zcpt.pojo.system.RolePrivi;

public interface IRolePriviService {

    Integer InsertRolePrivi(RolePrivi rolePrivi);

    Integer deleteRPById(Integer id);

    Integer updateRolePrivi(RolePrivi rolePrivi);
}
