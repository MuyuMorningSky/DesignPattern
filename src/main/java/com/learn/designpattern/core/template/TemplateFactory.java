package com.learn.designpattern.core.template;

import com.learn.designpattern.util.SpringUtils;
import org.springframework.stereotype.Component;

@Component
public class TemplateFactory {

    public void getPayCallCallTemplate(String templateId) {
        AbstractPayCallback payCallback = SpringUtils.getBean(templateId, AbstractPayCallback.class);
        payCallback.asyncPayCallback();
    }
}
