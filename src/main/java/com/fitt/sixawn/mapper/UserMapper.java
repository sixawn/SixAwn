/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fitt.sixawn.entity.User;

/**
 * <p>@description : UserMapper </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据主键ID获取用户
     * @param id 主键ID
     * @return User
     */
    User getById(Integer id);
}
