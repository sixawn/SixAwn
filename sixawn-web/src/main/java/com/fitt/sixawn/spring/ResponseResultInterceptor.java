/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.spring;

import com.fitt.sixawn.annotation.ResponseResultAnnotation;
import com.fitt.sixawn.constants.SixawnConsts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <p>@description 返回值统一处理拦截器 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-09
 */
@Slf4j
@Component
public class ResponseResultInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HttpMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            if (clazz.isAnnotationPresent(ResponseResultAnnotation.class)) {
                request.setAttribute(SixawnConsts.RESP_RET_ANN, clazz.getAnnotation(ResponseResultAnnotation.class));
            } else if (method.isAnnotationPresent(ResponseResultAnnotation.class)) {
                request.setAttribute(SixawnConsts.RESP_RET_ANN, method.getAnnotation(ResponseResultAnnotation.class));
            }
        }
        return true;
    }
}
