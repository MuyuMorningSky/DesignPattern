package com.learn.designpattern.core.proxy;


import com.learn.designpattern.core.proxy.cglib.CgLibProxy;
import com.learn.designpattern.core.proxy.jdk.JdkProxy;
import com.learn.designpattern.core.proxy.service.OrderService;
import com.learn.designpattern.core.proxy.service.OrderServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

@Component
public class ProxyFactory {

    public void jdkProxy(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService orderService = (OrderService) Proxy.newProxyInstance(OrderService.class.getClassLoader(), new Class[]{OrderService.class}, new JdkProxy(new OrderServiceImpl()));
        orderService.service02();
    }

    public void cglibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceImpl.class);
        enhancer.setCallback(new CgLibProxy());
        OrderServiceImpl orderServiceImpl = (OrderServiceImpl) enhancer.create();
        orderServiceImpl.service01();
    }

}
