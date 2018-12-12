/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.sixawn.web.controller;

import com.fitt.sixawn.domain.User;
import com.fitt.sixawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 用户信息控制器
 * @since : 2018/07/13
 */
@RestController(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询
     *
     * @return List<User>
     */
    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    /**
     * 新增
     *
     * @param user 用户
     * @return User
     */
    @PostMapping
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    /**
     * 修改
     *
     * @param user 用户
     * @return User
     */
    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);

    }

    /**
     * 删除
     *
     * @param user 用户
     */
    @DeleteMapping
    public User delete(@RequestBody User user) {
        return userService.delete(user);
    }
}
