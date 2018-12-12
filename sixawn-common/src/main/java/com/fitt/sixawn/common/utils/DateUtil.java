/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.sixawn.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : 日期时间工具类
 * @since : 2018/07/13
 */
public class DateUtil {

    /**
     * 返回当前系统时间
     * @param format 格式: 默认 yyyy-MM-dd HH:mm:ss
     * @return java.util.Date
     */
    public static Date stringToDate(String dateStr, String format) {
        if (null == dateStr || "".equalsIgnoreCase(dateStr.trim())) {
            return null;
        }

        if (null == format || "".equalsIgnoreCase(format.trim())) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
}
