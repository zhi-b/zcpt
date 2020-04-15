package com.zcpt.pojo.projects;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("collection")
@Data
public class Collection implements Serializable {
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer  id;
    private Integer userId;
    private Integer projectId;
}
