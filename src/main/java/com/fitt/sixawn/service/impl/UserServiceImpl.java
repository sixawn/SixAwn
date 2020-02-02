/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fitt.sixawn.dto.ResultDTO;
import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.mapper.UserMapper;
import com.fitt.sixawn.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>@description : 用户服务实现类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getById(Integer id) {
        return baseMapper.getById(id);
    }

    @Override
    public User getByPhoneAndPassword(User user) {
        // 根据手机号查询用户
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone", user.getPhone());
        queryWrapper.eq("password", user.getPassword());
        return baseMapper.selectOne(queryWrapper);
    }
}
