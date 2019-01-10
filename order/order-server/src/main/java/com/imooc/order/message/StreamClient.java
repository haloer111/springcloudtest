package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author gexiao
 * @date 2018/12/19 下午 11:44
 */
public interface StreamClient {

    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessage1")
    MessageChannel output();
}
