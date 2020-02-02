/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn.consts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@description : 常量类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2019-08-09 </p>
 * <p>@version : 1.0.0 </p>
 */
public class SixawnConsts {

    public static final String TITLE_STRING = "1-主任医师;2-副主任医师;3-主治医师;4-住院医师;5-主任护师;6-副主任护师;7-主管护师;8-护师;9-护士";

    /**
     * 医生系列：主任医师;副主任医师;主治医师;住院医师; 护理系列：主任护师;副主任护师;主管护师;护师;护士
     *
     * @return Map
     */
    public static Map<String, String> getTitleMap() {
        Map<String, String> titleMap = new HashMap<>(10);
        Arrays.stream(TITLE_STRING.split(";")).forEach(str -> {
            String[] title = str.split("-");
            titleMap.put(title[0], title[1]);
        });

        return titleMap;
    }
}
