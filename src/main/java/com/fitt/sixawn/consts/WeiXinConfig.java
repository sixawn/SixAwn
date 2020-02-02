package com.fitt.sixawn.consts;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>@description : description  </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2020-02-01 21:38 </p>
 * <p>@version : 1.0.0 </p>
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WeiXinConfig {
    private String appId;
    private String AppSecret;
    private String tokenUrl;
    private String redirectUrl;
    private String openIdUrl;
    private String userInfoUrl;
}
