/*
 * Copyright (c) 2020 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fitt.sixawn.constants.SixawnConsts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

/**
 * <p>@description 短链对象 </p>
 * <p>@author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since 2020-03-24 </p>
 * <p>@version 1.0.0 </p>
 */
@Data
@Builder
@ApiModel("短链表")
@TableName("sa_super_link")
public class SuperLink extends BaseEntity {
    private static final long serialVersionUID = 2252785966964778278L;

    @ApiModelProperty(" 原始链接 ")
    private String originLink;

    @ApiModelProperty(" 短链接 ")
    private String briefLink;

    @ApiModelProperty(" 短连接生成算法;1-MD5;2-MurmurHash;3-snowflake; ")
    private Integer genAlgo;

    @ApiModelProperty("短链全路径")
    @TableField(exist = false)
    private String fullBriefLink;

    public String getFullBriefLink() {
        return SixawnConsts.BRIEF_LINK_PREFIX + this.briefLink;
    }

}
