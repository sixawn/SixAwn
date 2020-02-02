package com.fitt.sixawn.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fitt.sixawn.consts.WeiXinConfig;
import com.fitt.sixawn.utils.HttpClientUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * <p>@description : description  </p>
 * <p>@author : <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a> </p>
 * <p>@since : 2020-02-01 21:50 </p>
 * <p>@version : 1.0.0 </p>
 */
@RestController("/wxAuth")
public class WeiXinController {
    @Resource
    private WeiXinConfig weiXinConfig;

    @RequestMapping("/login")
    public void wxLogin(HttpServletResponse response) throws IOException {
        //请求获取code的回调地址
        //用线上环境的域名或者用内网穿透，不能用ip
        String callBack = "http://sixawn.free.idcfengye.com/wxAuth/callBack";

        //请求地址
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize" +
                "?appid=" + weiXinConfig.getAppId() +
                "&redirect_uri=" + URLEncoder.encode(callBack) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=STATE#wechat_redirect";
        //重定向
        response.sendRedirect(url);
    }

    //	回调方法
    @RequestMapping("/callBack")
    public void wxCallBack(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String code = request.getParameter("code");

        //获取access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=" + weiXinConfig.getAppId() +
                "&secret=" + weiXinConfig.getAppSecret() +
                "&code=" + code +
                "&grant_type=authorization_code";

        String result = HttpClientUtils.doGet(url);

        System.out.println("请求获取access_token:" + result);
        //返回结果的json对象
        JSONObject resultObject = JSON.parseObject(result);

        //请求获取userInfo
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                "?access_token=" + resultObject.getString("access_token") +
                "&openid=" + resultObject.getString("openid") +
                "&lang=zh_CN";

        String resultInfo = HttpClientUtils.doGet(infoUrl);

        System.err.println("用户openid:" + resultObject.getString("openid"));
        System.err.println("名字:" + resultObject.getString("nickname"));
        // 值为1时是男性，值为2时是女性，值为0时是未知
        System.err.println("性别:" + resultObject.getString("sex"));
        System.err.println("省份:" + resultObject.getString("province"));
        System.err.println("城市:" + resultObject.getString("city"));
        System.err.println("国家:" + resultObject.getString("country"));
        System.err.println("头像:" + resultObject.getString("headimgurl"));
        System.err.println("特权:" + resultObject.getString("privilege"));
        System.err.println("unionid:" + resultObject.getString("unionid"));

        //此时已获取到userInfo，再根据业务进行处理
        System.out.println("请求获取userInfo:" + resultInfo);

    }
}
