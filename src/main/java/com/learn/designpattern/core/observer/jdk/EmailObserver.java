package com.learn.designpattern.core.observer.jdk;

import com.learn.designpattern.core.observer.subject.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
public class EmailObserver implements Observer {

    @Override
    public void update(Observable o, Object message) {
        log.info(message.toString() + ">>>>>>>>>>>>>邮件发送");
    }

}
