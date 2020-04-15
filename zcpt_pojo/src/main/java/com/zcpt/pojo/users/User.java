package com.zcpt.pojo.users;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 前端账户表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:45:36
 */
@Data
@TableName("tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 创建时间
	 */
	private Date created;
	/**
	 * 是否实名
	 */
	private String isRealnameCheck;

}
