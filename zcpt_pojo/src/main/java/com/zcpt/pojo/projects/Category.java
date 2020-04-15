package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目类型表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:36:36
 */
@Data
@TableName("category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 项目类型
	 */
	private String proCategory;

}
