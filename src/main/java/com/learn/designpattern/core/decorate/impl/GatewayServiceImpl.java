package com.learn.designpattern.core.decorate.impl;

import com.learn.designpattern.core.decorate.GatewayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GatewayServiceImpl implements GatewayService {

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>>>>基本组件");
    }
}
