package com.learn.designpattern.core.strategy.impl;

import com.learn.designpattern.core.strategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("WechatPayStrategy")
public class WechatPayStrategy implements PayStrategy {
    @Override
    public void pay() {
        log.info(">>>>>>>>>>>微信支付");
    }
}
