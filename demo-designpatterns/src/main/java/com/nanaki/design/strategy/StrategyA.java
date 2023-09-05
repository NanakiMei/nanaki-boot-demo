package com.nanaki.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@Component
public class StrategyA implements IStrategy{
    @Override
    public String routing() {
        return "A";
    }

    @Override
    public Object exec() {
        return "A.exec";
    }
}
