package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 答疑表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:36:36
 */
@Data
@TableName("answer")
public class Answer implements Serializable {
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
	 * 项目id
	 */
	private Integer projectId;
	/**
	 * 答疑详情
	 */
	private String ansDetail;
	/**
	 * 答疑时间
	 */
	private Date ansTime;

}
