package com.zcpt.system;


import com.zcpt.pojo.system.Role;

import java.util.List;

public interface IRoleService {
    Role findRoleById(Integer id);

    List<Role> findAllRole();

    Integer updateRole(Role role);

    Integer deleteRole(Integer id);

    Integer insertRole(Role role);
}
