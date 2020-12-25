/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fitt.sixawn.entity.ShortLink;

/**
 * <p>@description 短链服务接口 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-25
 */
public interface ShortLinkService extends IService<ShortLink> {
    /**
     * <p>@title getByOriginLink </p>
     * <p>@description 根据短链查询短链信息 </p>
     *
     * @param shortLink 原始长地址
     * @return ShortLink
     * @since x.y.z by Sixawn.ZHENG
     */
    ShortLink getByOriginLink(ShortLink shortLink);
}
