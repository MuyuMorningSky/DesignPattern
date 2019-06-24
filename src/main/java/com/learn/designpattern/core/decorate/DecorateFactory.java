package com.learn.designpattern.core.decorate;

import com.learn.designpattern.core.decorate.impl.GatewayServiceImpl;
import com.learn.designpattern.core.decorate.impl.LimitDecorate;
import com.learn.designpattern.core.decorate.impl.LogDecorate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DecorateFactory {

    @Autowired
    private LimitDecorate limitDecorate;
    @Autowired
    private LogDecorate logDecorate;
    @Autowired
    private GatewayServiceImpl gatewayServiceImpl;

    public LimitDecorate getGatewayComponent() {
        //网关 ---》 日志  --》 限流
        logDecorate.setAbstractDecorate(gatewayServiceImpl);
        limitDecorate.setAbstractDecorate(logDecorate);
        return limitDecorate;
    }
}
