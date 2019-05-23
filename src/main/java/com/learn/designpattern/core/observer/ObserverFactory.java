package com.learn.designpattern.core.observer;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.learn.designpattern.core.observer.jdk.EmailObserver;
import com.learn.designpattern.core.observer.jdk.MessageObservable;
import com.learn.designpattern.core.observer.jdk.SmsObserver;
import com.learn.designpattern.core.observer.spring.MessageEvent;
import com.learn.designpattern.core.observer.subject.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ObserverFactory {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void jdkObserver() {
        MessageObservable observable = new MessageObservable();
        observable.addObserver(new SmsObserver());
        observable.addObserver(new EmailObserver());
        observable.notifyObservers("JDK发送消息：");
    }

    public void springObserver() {
        Message message = new Message();
        message.setContent("Spring发送消息");
        MessageEvent messageEvent = new MessageEvent(message);
        applicationEventPublisher.publishEvent(messageEvent);
    }
}
