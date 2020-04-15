package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目进度表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:36:36
 */
@Data
@TableName("progress")
public class Progress implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 项目id
	 */
	private Integer projectId;
	/**
	 * 当前进度
	 */
	private String rate;
	/**
	 * 时间
	 */
	private Date time;

}
