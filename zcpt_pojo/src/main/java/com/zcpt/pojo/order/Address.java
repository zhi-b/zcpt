package com.zcpt.pojo.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 收货地址表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-14 22:42:37
 */
@Data
@TableName("tb_address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 收货地址
	 */
	private String address;
	/**
	 * 收货人姓名
	 */
	private String addrName;
	/**
	 * 收货人手机号码
	 */
	private String addrPhone;

}
