package com.learn.designpattern.core.decorate.impl;

import com.learn.designpattern.core.decorate.AbstractDecorate;
import com.learn.designpattern.core.decorate.AbstractGatewayComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LimitDecorate extends AbstractDecorate {

    public LimitDecorate(AbstractGatewayComponent abstractGatewayComponent) {
        super(abstractGatewayComponent);
    }

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>>>>网关限流");
        super.service();
    }
}
