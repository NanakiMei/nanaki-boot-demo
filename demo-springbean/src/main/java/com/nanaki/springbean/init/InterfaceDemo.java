package com.nanaki.springbean.init;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/12/20
 */
public class InterfaceDemo {

    public static void main(String[] args) throws IOException {

        String maskBit = StringUtils.removeStart("mask_24", "mask_");
        System.out.println(maskBit);

        System.out.println(InetAddress.getByName("127.0.0.1").isReachable(1000));
        System.out.println(InetAddress.getByName("www.baidu.com").isReachable(1000));
        System.out.println(InetAddress.getByName("172.16.44.75").isReachable(1000));
        System.out.println(InetAddress.getByName("172.17.44.71").isReachable(1000));
    }

}
