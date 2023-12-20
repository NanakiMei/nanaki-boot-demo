package com.nanaki.common;

import cn.hutool.crypto.digest.DigestUtil;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/11/24
 */
public class Md5Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String value = "123456";
        System.out.println(DigestUtil.md5Hex(value));
        System.out.println(DigestUtil.md5(value));
        System.out.println(md5(value));
    }

    private static String md5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));

        // 将处理后的字节转成 16 进制，得到最终 32 个字符
        StringBuilder sb = new StringBuilder();
        for (byte b : md5) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
