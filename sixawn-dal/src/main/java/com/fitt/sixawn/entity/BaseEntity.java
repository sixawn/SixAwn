/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * <p>@description 实体基础类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-03
 */
@Data
public class BaseEntity<T extends Model<?>> extends Model<T> {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 状态: -1-已删除，0-无效，1-有效；
     */
    private Integer status;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间，毫秒；
     */
    private Long created;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间，毫秒
     */
    private Long modified;


    // ********** 分页参数 **********
    /**
     * 第几页，默认第一页
     */
    @TableField(exist = false)
    private Integer pageNo = 1;
    /**
     * 每页多少条记录，默认 10 条
     */
    @TableField(exist = false)
    private Integer pageSize = 10;
    /**
     * 总页数
     */
    @TableField(exist = false)
    private Integer pageTotal;
}
