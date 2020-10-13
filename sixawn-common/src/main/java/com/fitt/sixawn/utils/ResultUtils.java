/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.utils;

import com.alibaba.fastjson.JSON;
import com.fitt.sixawn.constants.ResultCodeEnum;
import com.fitt.sixawn.dto.ResultDTO;

/**
 * <p>@description : 响应工具类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-07 </p>
 * <p>@version : 1.0.0 </p>
 */
public class ResultUtils {
    public static String render(ResultCodeEnum resultCode, Object data) {
        return render(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static String render(String code, String msg, Object data) {
        ResultDTO resultDTO = new ResultDTO(code, msg, data);
        return JSON.toJSONString(resultDTO);
    }

    public static String success(String code, String msg) {
        return render(code, msg, null);
    }

    public static String success(Object data) {
        return render(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), data);
    }

    public static String fail(String code, String msg, Object data) {
        return render(code, msg, null);
    }

    public static String fail() {
        return render(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMsg(), null);
    }

    public static String fail(Object data) {
        return render(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.ERROR.getMsg(), data);
    }
}
