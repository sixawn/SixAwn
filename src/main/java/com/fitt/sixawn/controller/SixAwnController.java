/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 前端控制器: Controller中是可以通过@Value注解读取到配置信息
 * @since : 2018/07/13
 */
@RestController
public class SixAwnController {
    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "SixAwn[username=" + username + ", password=" + password + "]";
    }
}
