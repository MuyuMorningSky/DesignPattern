package com.learn.designpattern.core.decorate.impl;

import com.learn.designpattern.core.decorate.AbstractDecorate;
import com.learn.designpattern.core.decorate.AbstractGatewayComponent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogDecorate extends AbstractDecorate {

    public LogDecorate(AbstractGatewayComponent abstractGatewayComponent) {
        super(abstractGatewayComponent);
    }

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>>>>网关日志");
        super.service();
    }

}
