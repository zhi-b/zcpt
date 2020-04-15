package com.zcpt.pojo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("manager")
@Data
public class Manager implements Serializable {
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    @TableField(value = "role_id")
    private Integer roleId;
}
