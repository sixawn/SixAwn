/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.constants;

/**
 * <p>@description : 系统响应码枚举类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public enum ResultCodeEnum {
    /**
     * 执行成功
     */
    SUCCESS("2000000", "执行成功", ""),

    /**
     * 路径相关错误
     */
    ERROR_PATH("3000000", "路径相关错误", ""),

    /**
     * 客户端相关错误
     */
    ERROR_REQUEST("4000000", "请求相关操作", ""),

    /**
     * 服务端相关错误
     */
    ERROR_SERVER("5000000", "请求相关操作", ""),
    /**
     * 未知错误
     */
    ERROR("9999999", "系统错误, 请联系管理员", "请联系管理员");

    String code;
    String msg;
    String solution;

    ResultCodeEnum(String code, String msg, String solution) {
        this.code = code;
        this.msg = msg;
        this.solution = solution;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
