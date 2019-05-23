package com.learn.designpattern.core.observer.jdk;

import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
public class SmsObserver implements Observer {

    @Override
    public void update(Observable o, Object message) {
        log.info(message + ">>>>>>>>>>>>>短信发送");
    }
}
