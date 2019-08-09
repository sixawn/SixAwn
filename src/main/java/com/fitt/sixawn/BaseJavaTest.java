/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */
package com.fitt.sixawn;

/**
 * <p>@description : TODO </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a> </p>
 * <p>@since : 2019-06-15 </p>
 * <p>@version : 1.0.0 </p>
 */
public class BaseJavaTest {
    public static void main(String[] args) {
        testLong();
    }

    public static void testLong() {
        int num = 2147483647;
        long temp = num + 2L;
        System.out.println(num);
    }
}
