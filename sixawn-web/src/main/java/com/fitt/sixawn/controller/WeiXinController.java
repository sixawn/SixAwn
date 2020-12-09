/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 FITT.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.controller;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.fitt.sixawn.utils.ResultUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@description 微信公众号相关接口 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/weixin")
public class WeiXinController extends BaseController {
    public static String GET_USERINFO = "https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID&lang=zh_CN";
    public static String GET_OPENID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
    public static String APPID = "APPID";
    public static String SECRET = "SECRET";

    /**
     * 测试URL
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Object index() {
        return ResultUtils.success(null);
    }


    /**
     * 获取openId  微信登录 获取用户姓名
     *
     * @param code
     * @return
     */
    @GetMapping(value = "/getOpenId", name = "根据code获取openid")
    public String getOpenId(@RequestParam("code") String code) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            map.put("status", 0);//默认失败
            map.put("appId", APPID);//为了给前端用
            if (!StringUtils.isEmpty(code)) {//有code
                //请求api获取openid(获取access_token,access_token里面带有openid)
                String path = GET_OPENID.replace("APPID", APPID).replace("SECRET", SECRET);
                String str = HttpUtil.createGet(path).execute().body();
                //将json转map
                Map<String, Object> toMap = JSONUtil.toBean(str, Map.class);
                if (!StringUtils.isEmpty(toMap.get("openid"))) {//获取openid成功
                    map.put("status", 1);//成功
                    map.put("openId", toMap.get("openid").toString());
                    map.put("access_token", toMap.get("access_token").toString());
                    //=================================================================================
                    //获取用户信息
                    path = GET_USERINFO.replace("TOKEN", toMap.get("access_token").toString()).replace("OPENID", toMap.get("openid").toString());
                    String str1 = HttpUtil.createGet(path).execute().body();
                    //将json转map
                    Map<String, Object> toMap1 = JSONUtil.toBean(str1, Map.class);
                    map1.put("nickname", toMap1.get("nickname").toString());//微信名
                    map1.put("sex", toMap1.get("sex").toString());//性别  值为1时是男性，值为2时是女性，值为0时是未知
                    map1.put("province", toMap1.get("province").toString());//省
                    map1.put("city", toMap1.get("city").toString());//城市
                    map1.put("country", toMap1.get("country").toString());//国家
                    map1.put("headimgurl", toMap1.get("headimgurl").toString());//用户头像
                    if (!StringUtils.isEmpty(str) && !StringUtils.isEmpty(str1)) {
                        result.put("openid", toMap.get("openid").toString());
                        result.put("nickname", toMap1.get("nickname").toString());
                    }
                    return ResultUtils.success(result);//返回openid
                } else {
                    return ResultUtils.fail("获取openid失败");
                }
            } else {
                return ResultUtils.fail("没有传入code值");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtils.fail(e.getMessage());
        }
    }
}
