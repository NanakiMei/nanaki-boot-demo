package com.nanaki.spi.google;

import com.google.auto.service.AutoService;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/10/13
 */
@AutoService(AutoApi.class)
public class AutoApi2 implements AutoApi {
    @Override
    public String getResource() {
        return "AutoApi2";
    }
}
