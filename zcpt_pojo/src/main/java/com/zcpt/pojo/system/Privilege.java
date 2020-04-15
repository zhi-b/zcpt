package com.zcpt.pojo.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("privilege")
@Data
public class Privilege implements Serializable {
    @TableId(value = "id" , type = IdType.AUTO)
    private Integer id;
    private String name;
    private String status;
}
