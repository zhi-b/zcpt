package com.zcpt.pojo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("role_privi")
@Data
public class RolePrivi implements Serializable {
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    @TableField("r_id")
    private Integer rId;
    @TableField("p_id")
    private Integer pId;
}
