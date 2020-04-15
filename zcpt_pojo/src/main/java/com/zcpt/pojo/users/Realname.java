package com.zcpt.pojo.users;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 实名信息表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:45:36
 */
@Data
@TableName("tb_realname")
public class Realname implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 身份证号
	 */
	private String idcard;
	/**
	 * 邮箱地址
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phone;
	/**
	 * 手持身份证照片的url
	 */
	private String img;
	/**
	 * 是否通过认证
	 */
	private String isPassCheck;

}
