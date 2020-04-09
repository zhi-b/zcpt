package com.zcpt.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("tb_brand")
@Data
public class Brand implements Serializable {
    @TableId("id")
    private Integer id;
    private String name;
    private String image;
    private String letter;
    private Integer seq;
}
