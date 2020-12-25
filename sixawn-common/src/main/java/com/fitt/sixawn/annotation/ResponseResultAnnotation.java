/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.annotation;

import java.lang.annotation.*;

/**
 * <p>@description 返回结果注解 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-09
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResultAnnotation {

}
