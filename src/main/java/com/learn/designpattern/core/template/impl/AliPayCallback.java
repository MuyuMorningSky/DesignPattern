package com.learn.designpattern.core.template.impl;

import com.learn.designpattern.core.template.AbstractPayCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service("AliPayCallback")
public class AliPayCallback extends AbstractPayCallback {

    @Override
    protected Map verifySignature() {
        log.info(">>>>>>>>>>>>支付宝银行回调报文");
        Map<String, Object> verifySignature = new HashMap<>();
        verifySignature.put("channelType", "ali");
        verifySignature.put("status","200");
        verifySignature.put("data", new HashMap<>());
        return verifySignature;
    }

    @Override
    protected void asyncService(Map<String, Object> verifySignatureMap) {
        log.info(">>>>>>>>>>>>支付宝业务逻辑。。。");
    }
}
