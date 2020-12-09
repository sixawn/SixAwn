/*******************************************************************************
 *                                                                             *
 * Copyright © 2015-2020 fitt.Ltd. All rights reserved.                         *
 *                                                                             *
 *******************************************************************************/
package com.fitt.sixawn.utils;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>@description 通用工具类 </p>
 *
 * @author <a href="mailto:congchun.zheng@gmail.com">Sixawn.ZHENG</a>
 * @version x.y.z
 * @since 2020-11-04
 */
@Slf4j
public class SixawnUtils {
    /**
     * <p>@title imageToBase64Str </p>
     * <p>@description 将图片转成 Base64 字符串 </p>
     *
     * @param imagePath 图片路径
     * @return java.lang.String
     * @since x.y.z by Sixawn.ZHENG
     */
    public static String imageToBase64Str(String imagePath) {
        byte[] data = null;
        String encode = null;

        BASE64Encoder encoder = new BASE64Encoder();
        try (InputStream in = new FileInputStream(imagePath)) {
            data = new byte[in.available()];
            in.read(data);
            encode = encoder.encode(data);
        } catch (Exception e) {
            log.error("[SixawnUtils.imageToBase64Str] occurred error.", e);
        }

        return encode;
    }

    /**
     * <p>@title base64StrToImage </p>
     * <p>@description 将 Base64 字符串转成图片 </p>
     *
     * @param imageBase64Str base64 字符串
     * @param imageFilePath  保存的图片路径
     * @return boolean
     * @since x.y.z by Sixawn.ZHENG
     */
    public static boolean base64StrToImage(String imageBase64Str, String imageFilePath) {
        BASE64Decoder decoder = new BASE64Decoder();

        try (OutputStream out = new FileOutputStream(imageFilePath)) {
            byte[] buffer = decoder.decodeBuffer(imageBase64Str);
            for (int i = 0; i < buffer.length; ++i) {
                if (buffer[i] < 0) {
                    buffer[i] += 256;
                }
            }
            out.write(buffer);
        } catch (Exception e) {
            log.error("[SixawnUtils.base64StrToImage] occurred error.", e);
            return false;
        }
        return true;
    }
}
