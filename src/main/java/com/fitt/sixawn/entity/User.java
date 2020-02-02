/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>@description : 用户信息表 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@ApiModel("数据专员")
@TableName("2019ncov_data_user")
public class User implements Serializable {
    @ApiModelProperty(" 唯一标识 ")
    private String id ;

    @ApiModelProperty(" 姓名 ")
    private String name;

    @ApiModelProperty(" 手机号 ")
    private String phone;

    @ApiModelProperty(" 部门 ")
    private String dept;

    @ApiModelProperty(" 职位 ")
    private String title;

    @ApiModelProperty(" 邮箱 ")
    private String email;

    @ApiModelProperty(" 分机号 ")
    private String mobile;

    @ApiModelProperty(" 密码;初试密码统一为手机号后6位 ")
    private String password;

    @ApiModelProperty(" 首次登录;1-首次登录，2-非首次即已修改密码 ")
    private Integer first_login;

    @ApiModelProperty(" 微信OpenID ")
    private String wx_open_id;

    @ApiModelProperty(" 微信UnionID ")
    private String wx_union_id;

    @ApiModelProperty(" 微信昵称 ")
    private String wx_nickname;

    @ApiModelProperty(" 微信头像 ")
    private String wx_head_img_url;

    @ApiModelProperty(" 状态;0-无效，1-有效 ")
    private Integer status;

    @ApiModelProperty(" 创建人 ")
    private String creator;

    @ApiModelProperty(" 创建时间;格式:时间戳 ")
    private Long created;

    @ApiModelProperty(" 修改人;修改人 ")
    private String modifier;

    @ApiModelProperty(" 修改时间;格式:时间戳 ")
    private Long modified;
}
