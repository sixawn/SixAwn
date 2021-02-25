/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2021 fitt.Ltd. All rights reserved.                        *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * <p>@description 网页抓取 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2021-02-03
 */
public class HtmlUtils {
    public static Document grab(String url) {
        String content = null;
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity, "utf-8");
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert content != null;
        return Jsoup.parse(content);
    }

    public static void main(String[] args) {
        Document doc = grab("https://baidu.com");
        System.out.println(doc.toString());
    }
}
