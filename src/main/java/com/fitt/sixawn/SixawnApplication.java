package com.fitt.sixawn;/*
 * Copyright (c) 2019 by FITT.inc All rights reserved
 */

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>@description : 系统主类 </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a> </p>
 * <p>@since : 2019-05-29 </p>
 * <p>@version : 1.0.0 </p>
 */
@MapperScan("com.fitt.sixawn.mapper")
@SpringBootApplication
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SixawnApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SixawnApplication.class).run(args);
    }

}
