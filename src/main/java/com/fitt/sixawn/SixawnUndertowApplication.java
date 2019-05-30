package com.fitt.sixawn;/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>@description : 系统主类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a> </p>
 * <p>@since : 2019-05-29 </p>
 * <p>@version : 1.0.0 </p>
 */
@SpringBootApplication
public class SixawnUndertowApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SixawnUndertowApplication.class).run(args);
    }

}
