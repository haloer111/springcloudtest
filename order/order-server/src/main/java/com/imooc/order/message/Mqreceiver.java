package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author gexiao
 * @date 2018/12/19 下午 10:58
 */
@Component
@Slf4j
public class Mqreceiver {

    //1. @RabbitListener(queues = "myQueue")
    //2. 自动声明队列
    // @RabbitListener(queuesToDeclare = @Queue("myQueue1"))
    //3.自动创建队列,Exchange和queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue2"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String msg) {
        log.info("Mqreceiver:{}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void processComputer(String msg) {
        log.info("computer receiver:{}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void processFruit(String msg) {
        log.info("fruit receiver:{}", msg);
    }
}
