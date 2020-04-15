package com.zcpt.pojo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@TableName("role")
@Data
public class Role implements Serializable {
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    private String name;
    private String introduction;
    @TableField(exist = false)
    private List<Privilege> privilegeList;
}