package com.learn.designpattern.core.decorate;

import org.springframework.stereotype.Component;

@Component
public class AbstractDecorate implements GatewayService {

    private GatewayService gatewayService;

    public void setAbstractDecorate(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }

    @Override
    public void service() {
        gatewayService.service();
    }

}
