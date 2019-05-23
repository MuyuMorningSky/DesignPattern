package com.learn.designpattern.core.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CgLibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info(">>>>>>>>>>>>>>CgLib收集日志开始");
        Object result = methodProxy.invokeSuper(obj, args);
        log.info(">>>>>>>>>>>>>>CgLib收集日志结束");
        return result;
    }
}
