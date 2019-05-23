package com.learn.designpattern.core.proxy.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceImpl implements OrderService{

    @Override
    public void service01() {
        log.info(">>>>>>>>>>>>>>执行业务第一种逻辑");
    }

    @Override
    public void service02() {
        log.info(">>>>>>>>>>>>>>执行业务第二种逻辑");
    }
}
