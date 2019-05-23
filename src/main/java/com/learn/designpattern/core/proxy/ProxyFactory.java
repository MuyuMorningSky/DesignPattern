package com.learn.designpattern.core.proxy;


import com.learn.designpattern.core.proxy.cglib.CgLibProxy;
import com.learn.designpattern.core.proxy.jdk.JdkProxy;
import com.learn.designpattern.core.proxy.service.OrderService;
import com.learn.designpattern.core.proxy.service.OrderServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;

@Component
public class ProxyFactory {

    public void jdkProxy(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService orderService = new JdkProxy(new OrderServiceImpl()).getProxy();
        orderService.service02();
    }

    public void cglibProxy() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:MyProject\\DesignPattern\\code");
        CgLibProxy cgLibProxy = new CgLibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceImpl.class);
        enhancer.setCallback(cgLibProxy);
        OrderServiceImpl orderServiceImpl = (OrderServiceImpl) enhancer.create();
        orderServiceImpl.service01();
    }

}
