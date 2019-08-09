/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>@description : 用户信息表 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@TableName("[user]")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String code;

    private String phone;

    /**
     * 职称: 医生系列：主任医师、副主任医师、主治医师、住院医师; 护理系列：主任护师、副主任护师、主管护师、护师、护士
     */
    private String title;

    @TableField("dept_code")
    private String deptCode;

    @TableField("dept_name")
    private String deptName;

}
