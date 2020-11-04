/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>@description : 用户信息表 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@TableName("sc_sys_user")
public class User extends BaseEntity<User> {
    /**
     * 工号
     */
    private String code;
    /**
     * 用户名
     */
    private String name;
    /**
     * 昵称
     */
    private String nick;
    /**
     * 登录密钥
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 头像连接
     */
    private String avatar;
    /**
     * 出生日期
     */
    private String birth;
    /**
     * 性别
     */
    private String gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 类型 预留
     */
    private String type;
    /**
     * 关键字
     */
    private String word;
    /**
     * 技能
     */
    private String skills;
    /**
     * 描述
     */
    private String description;
    /**
     * 身份证号
     */
    private String id_card;
    /**
     * 微信号
     */
    private String wechat_id;
    /**
     * 微信昵称
     */
    private String wechat_name;
    /**
     * 微信开发者ID
     */
    private String wechat_openid;
    /**
     * 微信头像
     */
    private String wechat_headimage;
    /**
     * 钉钉号
     */
    private String dingtalk_uid;
    /**
     * 钉钉昵称
     */
    private String dingtalk_nick;
    /**
     * 首次登陆 首次登陆0是，1否
     */
    private String first_login;
    /**
     * 扩展字段
     */
    private String extract;
}
