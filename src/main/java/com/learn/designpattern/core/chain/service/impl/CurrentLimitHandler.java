package com.learn.designpattern.core.chain.service.impl;

import com.learn.designpattern.core.chain.service.GatewayHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * 接口限流
 * @Author zhangw
 * @Date 10:54 10:54
 **/
@Component
@Slf4j
public class CurrentLimitHandler extends GatewayHandler {

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>接口限流");
        nextHandler();
    }
}
