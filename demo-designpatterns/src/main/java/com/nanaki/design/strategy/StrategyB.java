package com.nanaki.design.strategy;

import org.springframework.stereotype.Component;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@Component
public class StrategyB implements IStrategy{
    @Override
    public String routing() {
        return "B";
    }

    @Override
    public Object exec() {
        return "B.exec";
    }
}
