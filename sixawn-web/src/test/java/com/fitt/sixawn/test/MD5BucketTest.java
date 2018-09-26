/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.sixawn.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @descripiton : MD5(UID)分桶算法
 * @since : 2018/09/26
 */
public class MD5BucketTest {
    public static void main(String[] args) {
        long id = 1200237550;
        long hashVal = 804868372911570010L;
        for (int i = 0; i < 20; i ++) {
            //long hash = getHashValue(String.valueOf(ucid));
            //System.out.println(ucid + ": " + hash + ": " + hash % 10);
            // id ++;
            System.out.println(hashVal + ": hashVal % 10 = " + (hashVal % 10));
            hashVal ++;
        }
    }

    /**
     * 获取 Hash 值
     * @param original 原始字符串
     * @return long
     */
    public static long getHashValue(String original) {
        String hashStr = buildHashString(original);
        return Long.parseUnsignedLong(hashStr.substring(hashStr.length() - 16, hashStr.length() - 1), 16);
    }

    /**
     * 生成 Hash 字符串
     * @param original 原始字符串
     * @return String
     */
    public static String buildHashString(String original) {
        String hashString = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] result = md5.digest(original.getBytes());
            hashString = byteArray2Hex(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashString;
    }

    /**
     * 将字节数组转化成字符串
     * @param byteArray 字节数组
     * @return String
     */
    public static String byteArray2Hex(byte[] byteArray) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray);
    }
}
