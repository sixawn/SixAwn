/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.controller;

import com.fitt.sixawn.entity.ShortLink;
import com.fitt.sixawn.service.ShortLinkService;
import com.fitt.sixawn.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description 短链服务API </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-25
 */
@RestController
@RequestMapping("link")
public class ShortLinkController extends BaseController<ShortLinkService, ShortLink> {

    @PostMapping(name = "获取短链")
    public String get(@RequestBody ShortLink shortLink) {
        return ResultUtils.success(this.service.getByOriginLink(shortLink));
    }
}
