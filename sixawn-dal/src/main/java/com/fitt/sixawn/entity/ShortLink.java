/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fitt.sixawn.constants.SixawnConsts;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@description 短链 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@TableName("sc_short_link")
public class ShortLink extends BaseEntity<ShortLink> {
    /**
     * 原始链接
     */
    private String originLink;

    /**
     * 短链接
     */
    private String briefLink;

    /**
     * 短连接生成算法;1-MD5;2-MurmurHash;3-snowflake;
     */
    private Integer genAlgo;

    /**
     * 短链全路径
     */
    @TableField(exist = false)
    private String fullBriefLink;

    public String getFullBriefLink() {
        return SixawnConsts.BRIEF_LINK_PREFIX + this.briefLink;
    }
}
