package com.learn.designpattern.core.strategy;

import com.learn.designpattern.util.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class StrategyFactory {

    public void getPayStrategy(String strategyId) {
        PayStrategy payStrategy = SpringUtils.getBean(strategyId, PayStrategy.class);
        payStrategy.pay();
    }
}
