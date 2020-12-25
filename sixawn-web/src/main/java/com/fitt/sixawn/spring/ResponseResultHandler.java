/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.spring;

import com.fitt.sixawn.annotation.ResponseResultAnnotation;
import com.fitt.sixawn.constants.SixawnConsts;
import com.fitt.sixawn.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>@description 返回值重写处理器 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-09
 */
@Slf4j
@ControllerAdvice(annotations = {ResponseResultAnnotation.class})
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter parameter, Class<? extends HttpMessageConverter<?>> converter) {
        ServletRequestAttributes attributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = attributes.getRequest();

        ResponseResultAnnotation resultAnnotation = (ResponseResultAnnotation) request.getAttribute(SixawnConsts.RESP_RET_ANN);
        return resultAnnotation != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter parameter,
                                  MediaType mediaType, Class<? extends HttpMessageConverter<?>> converter,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        return ResultUtils.success(body);
    }
}
