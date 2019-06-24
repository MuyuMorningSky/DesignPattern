package com.learn.designpattern.core.decorate.impl;

import com.learn.designpattern.core.decorate.AbstractDecorate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LimitDecorate extends AbstractDecorate {

    @Override
    public void service() {
        log.info(">>>>>>>>>>>>>>>>网关限流");
        super.service();
    }
}
