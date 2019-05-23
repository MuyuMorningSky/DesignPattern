package com.learn.designpattern.core.chain.service.impl;

import com.learn.designpattern.core.chain.service.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 黑名单
 * @Author zhangw
 * @Date 10:53 10:53
 **/
@Component
@Slf4j
public class BlacklistHandler extends GatewayHandler {

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>黑名单");
        nextHandler();
    }
}
