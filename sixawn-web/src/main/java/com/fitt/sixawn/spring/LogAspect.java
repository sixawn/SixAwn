/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.spring;

import com.alibaba.fastjson.JSON;
import com.fitt.sixawn.dto.RequesterDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@description 日志切面 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-10-23
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.fitt.sixawn.controller..*(..))")
    public void pointCut() {
    }

    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequesterDTO requesterDTO = RequesterDTO.builder()
                .remoteIp(request.getRemoteAddr())
                .localIp(request.getLocalAddr())
                .userId(request.getRemoteUser())
                .url(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .classMethod(String.format("%s.%s",
                        joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName()))
                .requestParams(JSON.toJSONString(joinPoint.getArgs()))
                .build();
        log.info("Request Info: {}", requesterDTO.toString());
    }


    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object result = proceedingJoinPoint.proceed();
        RequesterDTO requesterDTO = RequesterDTO.builder()
                .remoteIp(request.getRemoteAddr())
                .localIp(request.getLocalAddr())
                .userId(request.getRemoteUser())
                .url(request.getRequestURL().toString())
                .httpMethod(request.getMethod())
                .classMethod(String.format("%s.%s",
                        proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                        proceedingJoinPoint.getSignature().getName()))
                .requestParams(getRequestParamsByProceedingJoinPoint(proceedingJoinPoint))
                .result(result)
                .timeCost(System.currentTimeMillis() - start)
                .build();
        log.info("Request Info: {}", requesterDTO.toString());

        return result;
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void doAfterThrow(JoinPoint joinPoint, RuntimeException e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        RequestErrorInfo requestErrorInfo = new RequestErrorInfo();
        requestErrorInfo.setIp(request.getRemoteAddr());
        requestErrorInfo.setUrl(request.getRequestURL().toString());
        requestErrorInfo.setHttpMethod(request.getMethod());
        requestErrorInfo.setClassMethod(String.format("%s.%s", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName()));
        requestErrorInfo.setRequestParams(getRequestParamsByJoinPoint(joinPoint));
        requestErrorInfo.setException(e);
        log.info("Error Request Info      : {}", JSON.toJSONString(requestErrorInfo));
    }

    /**
     * 获取入参
     *
     * @param proceedingJoinPoint
     * @return
     */
    private Map<String, Object> getRequestParamsByProceedingJoinPoint(ProceedingJoinPoint proceedingJoinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature) proceedingJoinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = proceedingJoinPoint.getArgs();

        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> getRequestParamsByJoinPoint(JoinPoint joinPoint) {
        //参数名
        String[] paramNames = ((MethodSignature) joinPoint.getSignature()).getParameterNames();
        //参数值
        Object[] paramValues = joinPoint.getArgs();

        return buildRequestParam(paramNames, paramValues);
    }

    private Map<String, Object> buildRequestParam(String[] paramNames, Object[] paramValues) {
        Map<String, Object> requestParams = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++) {
            Object value = paramValues[i];

            //如果是文件对象
            if (value instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) value;
                //获取文件名
                value = file.getOriginalFilename();
            }

            requestParams.put(paramNames[i], value);
        }

        return requestParams;
    }

    @Data
    public class RequestErrorInfo {
        private String ip;
        private String url;
        private String httpMethod;
        private String classMethod;
        private Object requestParams;
        private RuntimeException exception;
    }
}
