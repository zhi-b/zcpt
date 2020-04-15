package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:36:36
 */
@TableName("project")
@Data
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 项目类型id
	 */
	private Integer categoryId;
	/**
	 * 筹资总资金
	 */
	private Double moneyTotal;
	/**
	 * 筹资天数
	 */
	private Integer daysTotal;
	/**
	 * 已筹资金
	 */
	private Double moneyHaved;
	/**
	 * 已筹天数
	 */
	private Integer daysHaved;
	/**
	 * 简介
	 */
	private String introduction;
	/**
	 * 标签
	 */
	private String label;
	/**
	 * 项目头图url
	 */
	private String imgHead;
	/**
	 * 项目详情图url

	 */
	private String imgDetails;
	/**
	 * 回报信息的id

	 */
	private Integer rewardId;
	/**
	 * 项目支持人数
	 */
	private Integer numberSupport;
	/**
	 * 项目收藏人数
	 */
	private Integer numberCollect;
	/**
	 * 项目创建时间
	 */
	private Date created;
	/**
	 * 简单自我介绍
	 */
	private String introSimple;
	/**
	 * 详细自我介绍
	 */
	private String introDetails;
	/**
	 * 项目发起人联系电话
	 */
	private String oriPhone;
	/**
	 * 客服电话
	 */
	private String teamPhone;
	/**
	 * 项目状态
	 */
	private String status;
	/**
	 *是否通过审核
	 */
	private String is_pass;
}
