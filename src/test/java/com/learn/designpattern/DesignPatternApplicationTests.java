package com.learn.designpattern;

import com.learn.designpattern.core.chain.service.ChainFactory;
import com.learn.designpattern.core.decorate.DecorateFactory;
import com.learn.designpattern.core.observer.ObserverFactory;
import com.learn.designpattern.core.proxy.ProxyFactory;
import com.learn.designpattern.core.strategy.StrategyFactory;
import com.learn.designpattern.core.template.TemplateFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignPatternApplicationTests {

    @Autowired
    private ChainFactory chainFactory;

    @Autowired
    private TemplateFactory templateFactory;

    @Autowired
    private StrategyFactory strategyFactory;

    @Autowired
    private DecorateFactory decorateFactory;

    @Autowired
    private ProxyFactory proxyFactory;

    @Autowired
    private ObserverFactory observerFactory;

    @Test
    public void contextLoads() {
    }

    @Test
    public void chain() {
        chainFactory.getGatewayHandler().service();
    }

    @Test
    public void decorate(){
        decorateFactory.getGatewayComponent().service();
    }

    @Test
    public void template() {
        templateFactory.getPayCallCallTemplate("AliPayCallback");
    }

    @Test
    public void strategy() {
        strategyFactory.getPayStrategy("AliPayStrategy");
    }

    @Test
    public void proxy(){
        proxyFactory.cglibProxy();
        proxyFactory.jdkProxy();
    }

    @Test
    public void observer() {
        observerFactory.jdkObserver();
        observerFactory.springObserver();
    }
}
