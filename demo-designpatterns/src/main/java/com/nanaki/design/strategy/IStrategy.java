package com.nanaki.design.strategy;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
public interface IStrategy {

    /**
     * 路由标识
     */
    String routing();

    /**
     * 执行策略
     */
    Object exec();

}
