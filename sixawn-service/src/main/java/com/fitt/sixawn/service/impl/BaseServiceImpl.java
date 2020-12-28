/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fitt.sixawn.entity.BaseEntity;
import com.fitt.sixawn.service.BaseService;

/**
 * <p>@description 抽象服务接口实现类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-28
 */
public abstract class BaseServiceImpl<Mapper extends BaseMapper<T>, T extends BaseEntity<T>>
        extends ServiceImpl<Mapper, T>
        implements BaseService<T> {
}
