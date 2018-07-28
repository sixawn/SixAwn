/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.common.enums;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 记录是否删除枚举类: 0-未删除, 1-已删除
 * @since : 2018/07/13
 */
public enum DeletedEnum {
    /**
     * 记录为删除
     */
    NOT_DELETED(0, "未删除"),
    /**
     * 记录已删除
     */
    DELETED(1, "已删除"),;

    Integer code;
    String desc;

    DeletedEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
