/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.repository;

import com.fitt.sixawn.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 用户信息持久化接口
 * @since : 2018/07/13
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
