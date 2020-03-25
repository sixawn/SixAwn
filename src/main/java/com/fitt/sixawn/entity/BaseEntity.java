/*
 * Copyright (c) 2020 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>@description 基础对象 </p>
 * <p>@author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since 2020-03-24 </p>
 * <p>@version 1.0.0 </p>
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -3034509351518495819L;

    @ApiModelProperty(" 唯一标识 ")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(" 状态;0-无效，1-有效 ")
    private Integer status;

    @ApiModelProperty(" 创建人 ")
    private String creator;

    @ApiModelProperty(" 创建时间;格式:时间戳 ")
    private Long created;

    @ApiModelProperty(" 修改人;修改人 ")
    private String modifier;

    @ApiModelProperty(" 修改时间;格式:时间戳 ")
    private Long modified;

    @ApiModelProperty(" 分页参数: 第几页，默认第 1 页 ")
    @TableField(exist = false)
    private Integer pageNo = 1;

    @ApiModelProperty(" 分数参数: 每页多少条，默认 20 条 ")
    @TableField(exist = false)
    private Integer pageSize = 20;
}
