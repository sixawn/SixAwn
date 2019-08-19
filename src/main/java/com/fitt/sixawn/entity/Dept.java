/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>@description : 科室表 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-19 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@TableName("[dept]")
public class Dept implements Serializable {

    /** 科室类型: 1-门诊;2-住院 */
    @TableField("dept_type")
    private String deptType;

    /** 科室编码，多个用英文逗号隔开 */
    @TableField("dept_code")
    private String deptCode;

    /** 科室名，多个用英文逗号隔开 */
    @TableField("dept_name")
    private String deptName;

    /** 科室类型: 1-儿童院区；2-珠江院区；3-妇婴院区；4-增城院区； */
    private String area;
}
