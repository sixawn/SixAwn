/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.service.UserService;
import com.fitt.sixawn.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@description : UserController </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController<UserService, User> {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return ResultUtils.success(this.service.list(null));
    }
}
