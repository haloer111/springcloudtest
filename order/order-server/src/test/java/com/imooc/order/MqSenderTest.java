package com.imooc.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author gexiao
 * @date 2018/12/19 下午 11:02
 */
@Component
public class MqSenderTest extends  OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send(){
        amqpTemplate.convertAndSend("myQueue1","now:"+new Date().toString());
    }
    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer","now:"+new Date().toString());
    }
}
