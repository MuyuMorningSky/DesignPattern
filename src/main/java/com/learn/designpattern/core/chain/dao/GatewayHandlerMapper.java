package com.learn.designpattern.core.chain.dao;

import com.learn.designpattern.core.chain.domain.GatewayHandlerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GatewayHandlerMapper {

    @Select("SELECT * FROM `gateway_handler` WHERE prev_handler_id is null;")
    GatewayHandlerEntity getFirstGatewayHandlerEntity();

    @Select("SELECT * FROM `gateway_handler` WHERE handler_id = #{nextHandlerId}")
    GatewayHandlerEntity getGatewayHandlerEntity(String nextHandlerId);
}
