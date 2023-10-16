package com.nanaki.spi.demo;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/26
 */
public class ASpi implements IJavaSpi, ISpringSpi{

    @Override
    public String getResource() {
        return "A";
    }

}
