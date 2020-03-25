/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fitt.sixawn.entity.SuperLink;

/**
 * <p>@description : 短链数据接口 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public interface SuperLinkMapper extends BaseMapper<SuperLink> {

    /**
     * <p>根据短链查询短链信息</p>
     * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
     * <p>@date 2020/3/24</p>
     * <p>@param superLink 短链参数 </p>
     * <p>@return {@link SuperLink}</p>
     * <p>@throws</p>
     */
    SuperLink getByOriginLink(SuperLink superLink);
}
