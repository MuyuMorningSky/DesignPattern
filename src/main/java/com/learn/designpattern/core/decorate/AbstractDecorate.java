package com.learn.designpattern.core.decorate;


public class AbstractDecorate extends AbstractGatewayComponent{

    private AbstractGatewayComponent abstractGatewayComponent;

    public AbstractDecorate(AbstractGatewayComponent abstractGatewayComponent) {
        this.abstractGatewayComponent = abstractGatewayComponent;
    }

    @Override
    public void service() {
        abstractGatewayComponent.service();
    }


}
