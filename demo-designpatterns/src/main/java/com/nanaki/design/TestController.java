package com.nanaki.design;

import com.nanaki.design.strategy.StrategyRunner;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
@RequestMapping("/api/design")
public class TestController {

    @Resource
    private StrategyRunner strategyRunner;

    @RequestMapping("/strategy/{route}")
    public @ResponseBody Object strategy(@PathVariable("route") String route) {
        return strategyRunner.run(route);
    }

}
