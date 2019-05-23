package com.learn.designpattern.core.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 抽象支付回调模板
 * @Author zhangw
 * @Date 14:16 14:16
 **/
@Slf4j
@Component
public abstract class AbstractPayCallback {

    /**
     * 1. 验证参数
     * 2. 日志记录
     * 3. 执行逻辑
     * @return
     */
    public void asyncPayCallback(){
        Map<String, Object> verifySignatureMap = verifySignature();
        String analysisCode = payLog(verifySignatureMap);
        if ( !StringUtils.equals("200", analysisCode)) {
            log.error(">>>>>>>>>>>>>异常处理。。。");
        }
        asyncService(verifySignatureMap);
    }

    protected abstract Map<String, Object> verifySignature();

    protected abstract void asyncService(Map<String, Object> verifySignatureMap);

    private String payLog(Map<String, Object> verifySignatureMap) {
        log.info(">>>>>>>>>>>>>>记录日志");
        return "200";
    }

}
