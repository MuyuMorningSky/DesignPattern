package com.learn.designpattern.core.observer.spring;

import com.learn.designpattern.core.observer.subject.Message;
import org.springframework.context.ApplicationEvent;

public class MessageEvent extends ApplicationEvent {

    public MessageEvent(Message message) {
        super(message);
    }
}
