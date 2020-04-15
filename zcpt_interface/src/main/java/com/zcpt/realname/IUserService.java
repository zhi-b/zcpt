package com.zcpt.realname;

/**
 * 通过验证实名信息中的审核状态 is_pass_check ，设置user的 is_realname_check
 */
public interface IUserService {
    //更改用户“是否通过实名审核”状态
    void modifyUserStatus(Integer id);
}
