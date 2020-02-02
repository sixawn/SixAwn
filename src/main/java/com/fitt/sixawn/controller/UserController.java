/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fitt.sixawn.consts.SixawnConsts;
import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.service.UserService;
import com.fitt.sixawn.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>@description : UserController </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    //------------------------MVC--------------------------------//

    /**
     * 跳转新增提交页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "请提交您信息");
        return "index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, User userDto) {
        User user = userService.getByPhoneAndPassword(userDto);


        model.addAttribute("message", ObjectUtils.isEmpty(user) ? "账号或密码不正确" : "登录成功");
        model.addAttribute("user", user);

        return ObjectUtils.isEmpty(user) ? "index" : "health/list";
    }
}
