/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.common.dto;

import java.io.Serializable;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 统一返回DTO
 * @since : 2018/07/28
 */
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 944119397473426897L;

    private static final Integer SUCCESS = 2000000;
    private static final Integer FAIL = 5000000;

    private T data;
    private Integer code;
    private String message;

    public ResultDTO() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static ResultDTO isSuccess() {
        return new ResultDTO();
    }

    public static ResultDTO isFail() {
        return new ResultDTO().code(FAIL);
    }

    public static ResultDTO isFail(Throwable e) {
        return isFail().message(e);
    }

    public ResultDTO message(Throwable e) {
        this.setMessage(e.toString());
        return this;
    }

    public ResultDTO data(T data) {
        this.setData(data);
        return this;
    }

    public ResultDTO<T> code(Integer code) {
        this.setCode(code);
        return this;
    }

}
