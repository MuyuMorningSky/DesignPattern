package com.learn.designpattern.core.observer.spring;

import com.learn.designpattern.core.observer.subject.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service("EmailObserver")
public class EmailListener implements ApplicationListener<MessageEvent> {

    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        Message source = (Message) messageEvent.getSource();
        log.info(source.getContent() + ">>>>>>>>>>>>>>邮件消息" );
    }
}
