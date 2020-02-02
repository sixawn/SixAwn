/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fitt.sixawn.dto.ResultDTO;
import com.fitt.sixawn.entity.User;

/**
 * <p>@description : 用户服务接口 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public interface UserService extends IService<User> {
    /**
     * 根据主键ID获取用户
     * @param id 主键ID
     * @return User
     */
    User getById(Integer id);

    /***
     * <p>@description : 用户登录 </p>
     * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
     * <p>@since : 2020/2/1 23:44 </p>
     * <p>@param user: 登录用户信息</p>
     * <p>@return: com.fitt.sixawn.entity.User</p>
     **/
    User getByPhoneAndPassword(User user);
}
