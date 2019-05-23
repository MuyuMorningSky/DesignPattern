package com.learn.designpattern.core.chain.service;

import com.learn.designpattern.core.chain.dao.GatewayHandlerMapper;
import com.learn.designpattern.core.chain.domain.GatewayHandlerEntity;
import com.learn.designpattern.util.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChainFactory {

    @Autowired
    private GatewayHandlerMapper gatewayHandlerMapper;

    private GatewayHandler gatewayHandler;

    public GatewayHandler getGatewayHandler() {
        //1. 数据库取第一个handlerId
        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandlerEntity();
        //2. spring容器获取第一个handler
        String handlerId = firstGatewayHandlerEntity.getHandlerId();
        GatewayHandler firstGatewayHandler = SpringUtils.getBean(handlerId, GatewayHandler.class);
        String nextHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
        //3. 设置临时实体
        GatewayHandler gatewayHandler = firstGatewayHandler;
        while (StringUtils.isNotBlank(nextHandlerId)) {
            //5. spring容器获取下一个handler
            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
            gatewayHandler.setNextGatewayHandler(nextGatewayHandler);
            //4. 数据库获取下一个handlerId
            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getGatewayHandlerEntity(nextHandlerId);
            if (nextGatewayHandlerEntity == null) {
                break;
            }
            nextHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
            //6. 设置下一个handler
            gatewayHandler = nextGatewayHandler;
        }
        this.gatewayHandler = gatewayHandler;
        return firstGatewayHandler;
    }

//    public GatewayHandler getGatewayHandler() {
//        if (gatewayHandler != null) {
//            return gatewayHandler;
//        }
//        // 1.从数据库中查询地址hanlder
//        GatewayHandlerEntity firstGatewayHandlerEntity = gatewayHandlerMapper.getFirstGatewayHandlerEntity();
//        if (firstGatewayHandlerEntity == null) {
//            return null;
//        }
//        // 2.获取springboot注入容器id
//        String handlerId = firstGatewayHandlerEntity.getHandlerId();
//        GatewayHandler firstGatewayHandler = SpringUtils.getBean(handlerId, GatewayHandler.class);
//        // 3.获取下一个handler容器beanid
//        String nextHandlerId = firstGatewayHandlerEntity.getNextHandlerId();
//        // 4. 记录当前循环hanlder对象
//        GatewayHandler tempGatewayHandler = firstGatewayHandler;
//        while (!StringUtils.isEmpty(nextHandlerId)) {
//            // 5.从springboot容器获取下一个handerl对象
//            GatewayHandler nextGatewayHandler = SpringUtils.getBean(nextHandlerId, GatewayHandler.class);
//            tempGatewayHandler.setNextGatewayHandler(nextGatewayHandler);
//            // 6.设置下一个nextHandlerId
//            GatewayHandlerEntity nextGatewayHandlerEntity = gatewayHandlerMapper.getGatewayHandlerEntity(nextHandlerId);
//            if (nextGatewayHandlerEntity == null) {
//                break;
//            }
//            nextHandlerId = nextGatewayHandlerEntity.getNextHandlerId();
//            tempGatewayHandler = nextGatewayHandler;
//        }
//        this.gatewayHandler = firstGatewayHandler;
//        return firstGatewayHandler;
//    }
}
