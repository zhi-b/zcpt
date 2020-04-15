package com.zcpt.pojo.order;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 支持的订单表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-14 22:42:37
 */
@Data
@TableName("order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 项目名称
	 */
	private String projectName;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 项目发起人名称
	 */
	private String originName;
	/**
	 * 回报内容
	 */
	private String content;
	/**
	 * 支持数量
	 */
	private Integer amount;
	/**
	 * 支持单价
	 */
	private Double moneyOne;
	/**
	 * 支持总额
	 */
	private Double moneyTotal;
	/**
	 * 运费
	 */
	private Double fare;
	/**
	 * 收货地址id
	 */
	private Integer addressId;
	/**
	 * 是否需要发票
	 */
	private String isInvoice;
	/**
	 * 发票抬头
	 */
	private String invoiceHead;

}
