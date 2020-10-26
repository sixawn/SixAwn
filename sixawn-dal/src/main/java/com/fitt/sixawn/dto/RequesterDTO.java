/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>@description 请求参数数据对象 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-10-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequesterDTO implements Serializable {
    private String userId;
    private String remoteIp;
    private String localIp;
    private String url;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private Object result;
    private Long timeCost;

}
