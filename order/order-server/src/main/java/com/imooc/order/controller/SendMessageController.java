package com.imooc.order.controller;

import com.imooc.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author gexiao
 * @date 2018/12/19 下午 11:54
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void sendMessage() {
        streamClient.output().send(MessageBuilder.withPayload("now" + new Date()).build());
    }
}
