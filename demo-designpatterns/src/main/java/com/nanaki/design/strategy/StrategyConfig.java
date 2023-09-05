package com.nanaki.design.strategy;

import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author nanaki_1995@163.com
 * @description:
 * @date 2023/9/4
 */
public class StrategyConfig {

    @Bean
    public StrategyRunner strategyRunner(List<IStrategy> strategies) {
        Map<String, IStrategy> strategyMap = strategies.stream()
                .collect(Collectors.toMap(IStrategy::routing, s -> s));

        return routing -> strategyMap.get(routing).exec();
    }

}
