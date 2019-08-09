/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fitt.sixawn.constants.SixawnConsts;
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

    //------------------------Restful Api--------------------------------//

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        return ResultUtils.success(userService.list(null));
    }

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

    /**
     * 跳转编辑提交页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(Model model, String id) {
        model.addAttribute("message", "请提交您信息");
        model.addAttribute("entity", userService.getById(id));
        return "edit";
    }

    /**
     * 删除提交页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, String id, String key) {
        userService.removeById(Integer.valueOf(id));
        return list(model, key);
    }

    /**
     * 跳转列表页
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model, String key) {
        if (!"gzfemdt".equalsIgnoreCase(key)) {
            model.addAttribute("message", "^V^, 此页面需访问密钥! 【天王盖地虎】那种黑话.");
            model.addAttribute("show", false);
            return "result";
        }

        List<User> userList = userService.list(null);
        userList.forEach(it -> it.setTitle(SixawnConsts.getTitleMap().get(it.getTitle())));

        model.addAttribute("list", userList);
        model.addAttribute("key", key);
        return "list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(Model model, User user) {
        String message = "保存成功";
        try {
            // 查询工号是否已提交
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("code", user.getCode());
            User entity = userService.getOne(queryWrapper);
            if (ObjectUtils.isEmpty(entity)) {
                userService.save(user);
            } else {
                message = "您已提交过信息";
                user = entity;
            }
        } catch (Exception ex) {
            message = "保存失败";
            logger.error("保存用户失败: {}", ex.getMessage(), ex);
        }

        model.addAttribute("message", message);
        model.addAttribute("entity", user);

        return "result";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, User user) {
        boolean result = userService.updateById(user);

        model.addAttribute("message", result ? "更新成功" : "更新失败");
        model.addAttribute("entity", user);

        return "result";
    }
}
