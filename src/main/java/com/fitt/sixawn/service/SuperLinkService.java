/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fitt.sixawn.entity.SuperLink;

/**
 * <p>@description : 服务接口 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public interface SuperLinkService extends IService<SuperLink> {
    /**
     * <p>根据短链查询短链信息</p>
     * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
     * <p>@date 2020/3/24</p>
     * <p>@param originLink 原始长地址 </p>
     * <p>@return {@link SuperLink}</p>
     * <p>@throws</p>
     */
    SuperLink getByOriginLink(SuperLink superLink);
}
