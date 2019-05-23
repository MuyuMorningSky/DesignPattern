package com.learn.designpattern.core.chain.service;


/**
 * 网关处理器
 * @Author zhangw
 * @Date 10:54 10:54
 **/
public abstract class GatewayHandler {

    protected GatewayHandler nextGatewayHandler;

    public void setNextGatewayHandler(GatewayHandler nextGatewayHandler) {
        this.nextGatewayHandler = nextGatewayHandler;
    }

    public abstract void service();

    public void nextHandler(){
        if (nextGatewayHandler != null){
            nextGatewayHandler.service();
        }
    }
}
