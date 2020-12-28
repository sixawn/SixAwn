/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.service.impl;

import com.fitt.sixawn.entity.User;
import com.fitt.sixawn.mapper.UserMapper;
import com.fitt.sixawn.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>@description : 用户服务实现类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Primary
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

}
