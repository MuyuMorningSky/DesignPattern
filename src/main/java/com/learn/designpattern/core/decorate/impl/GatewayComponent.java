package com.learn.designpattern.core.decorate.impl;

import com.learn.designpattern.core.decorate.AbstractGatewayComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GatewayComponent extends AbstractGatewayComponent {

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>>>>基本组件");
    }
}
