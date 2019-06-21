package com.learn.designpattern.core.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class JdkProxy implements InvocationHandler {

    /**
     * 被代理类对象 目标代理对象
     */
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info(">>>>>>>>>>>>>>JDK收集日志开始");
        Object result = method.invoke(target, args);
        log.info(">>>>>>>>>>>>>>JDK收集日志结束");
        return result;
    }


}
