package com.learn.designpattern.core.observer.spring;

import com.learn.designpattern.core.observer.subject.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service("SmsObserver")
public class SmsListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        Message message = (Message) messageEvent.getSource();
        log.info(message.getContent() + ">>>>>>>>>>>>>>短信消息" );
    }
}
