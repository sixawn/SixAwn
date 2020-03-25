/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.fitt.sixawn.entity.SuperLink;
import com.fitt.sixawn.service.SuperLinkService;
import com.fitt.sixawn.utils.ResultUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>@description : 短链服务API </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@RestController
@RequestMapping("link")
public class ShortLinkController {
    private static Logger logger = LoggerFactory.getLogger(ShortLinkController.class);

    @Resource
    private SuperLinkService shortLinkService;

    @ApiOperation(value = "获取短链", notes = "获取短链")
    @PostMapping
    public String get(@RequestBody SuperLink superLink) {
        return ResultUtils.success(shortLinkService.getByOriginLink(superLink));
    }

}
