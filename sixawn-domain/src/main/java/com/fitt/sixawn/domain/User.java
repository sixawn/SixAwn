/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.sixawn.domain;

import com.fitt.sixawn.common.enums.DeletedEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 用户信息实体
 * @since : 2018/07/13
 */
@Data
@Entity(name = "sa_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer deleted;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "modify_time")
    private Date modifyTime;

    public static User of(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setDeleted(DeletedEnum.NOT_DELETED.getCode());

        Date now = new Date();
        user.setCreateTime(now);
        user.setModifyTime(now);
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", deleted=" + deleted +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            '}';
    }
}
