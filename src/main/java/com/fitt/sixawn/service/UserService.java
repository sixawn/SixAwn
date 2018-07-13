/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.service;

import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.enums.DeletedEnum;
import com.fitt.sixawn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 用户业务服务类
 * @since : 2018/07/13
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        Date now = new Date();
        user.setCreateTime(now);
        user.setModifyTime(now);
        user.setDeleted(DeletedEnum.NOT_DELETED.getCode());
        return userRepository.save(user);
    }

    public User update(User user) {
        Optional<User> dbUser = userRepository.findById(user.getId());
        if (!dbUser.isPresent()) {
            return null;
        }

        dbUser.get().setModifyTime(new Date());
        if (StringUtils.isEmpty(user.getUsername())) {
            dbUser.get().setUsername(user.getUsername());
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            dbUser.get().setPassword(user.getPassword());
        }

        return userRepository.save(dbUser.get());
    }

    /**
     * 删除用户
     * @param user 用户信息
     * @return User
     */
    public User delete(User user) {
        Optional<User> dbUser = userRepository.findById(user.getId());
        if (!dbUser.isPresent()) {
            return null;
        }

        dbUser.get().setDeleted(DeletedEnum.DELETED.getCode());
        dbUser.get().setModifyTime(new Date());

        return userRepository.save(dbUser.get());
    }
}
