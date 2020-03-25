/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>@description : 常量类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-09 </p>
 * <p>@version : 1.0.0 </p>
 */
public interface SixawnConsts {

    Integer STATUS_MINUS_ONE = -1;
    Integer STATUS_ZERO = 0;
    Integer STATUS_ONE = 1;
    Integer STATUS_TWO = 2;
    Integer STATUS_THREE = 3;
    Integer STATUS_FOUR = 4;
    Integer STATUS_FIVE = 5;
    Integer STATUS_SIX = 6;
    Integer STATUS_SEVEN = 7;
    Integer STATUS_EIGHT = 8;
    Integer STATUS_NINE = 9;

    /**
     * 短链重复时在长链后面追加字符串用于再次生成短链
     */
    String URL_DUPLICATE_STRING = "&SUPER_LINK";

    /**
     * 短链全路径前缀
     */
    String BRIEF_LINK_PREFIX = "http://127.0.0.1:8899/a/";

    @Getter
    @AllArgsConstructor
    enum GenAlgoEnum {
        /**
         * 普通哈希函数生成
         */
        HASH("hash", ""),
        /**
         * 谷歌 murmurhash
         */
        MURMURHASH("murmurhash", ""),
        /**
         * 雪花算法
         */
        SNOWFLAKE("snowflake", ""),
        ;


        String code;
        String algo;
    }

}