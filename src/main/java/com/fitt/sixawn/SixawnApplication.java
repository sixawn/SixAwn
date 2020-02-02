package com.fitt.sixawn;/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>@description : 系统主类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a> </p>
 * <p>@since : 2019-05-29 </p>
 * <p>@version : 1.0.0 </p>
 */
@MapperScan("com.fitt.sixawn.mapper")
@SpringBootApplication
public class SixawnApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SixawnApplication.class).run(args);
    }

}
