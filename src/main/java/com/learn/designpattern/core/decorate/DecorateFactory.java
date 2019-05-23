package com.learn.designpattern.core.decorate;

import com.learn.designpattern.core.decorate.impl.GatewayComponent;
import com.learn.designpattern.core.decorate.impl.LimitDecorate;
import com.learn.designpattern.core.decorate.impl.LogDecorate;
import org.springframework.stereotype.Component;

@Component
public class DecorateFactory {

    public LimitDecorate getGatewayComponent() {
        return new LimitDecorate(new LogDecorate(new GatewayComponent()));
    }
}
