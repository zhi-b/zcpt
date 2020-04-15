package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 问题表
 * 
 * @author chenshun
 * @email zhi233@foxmail.com
 * @date 2020-04-11 09:36:36
 */
@Data
@TableName("question")
public class Question implements Serializable {
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
	 * 提问详情
	 */
	private String queDetail;
	/**
	 * 提问时间
	 */
	private Date queTime;

	private List<Answer> answerList;
}
