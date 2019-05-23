package com.learn.designpattern.core.chain.domain;

import lombok.Data;

@Data
public class GatewayHandlerEntity {

    private int id;

    private String handlerId;

    private String prevHandlerId;

    private String nextHandlerId;
}
