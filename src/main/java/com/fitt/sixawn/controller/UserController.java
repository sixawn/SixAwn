/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.controller;

import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.enums.DeletedEnum;
import com.fitt.sixawn.repository.UserRepository;
import com.fitt.sixawn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
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
