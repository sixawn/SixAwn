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

    /** 开通权限: 1-会诊;2-转运 */
    @TableField("permission")
    private String permission;

    /** 职称: 1-主任医师；2-副主任医师；3-主治医师；4-住院医师；5-主任护师；6-副主任护师；7-主管护师；8-护师；9-护士*/
    private String title;

    /** 科室编码，多个用英文逗号隔开 */
    @TableField("dept_code")
    private String deptCode;

    /** 科室名，多个用英文逗号隔开 */
    @TableField("dept_name")
    private String deptName;

}
