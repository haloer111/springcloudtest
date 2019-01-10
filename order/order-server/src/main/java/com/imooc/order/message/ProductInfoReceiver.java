package com.imooc.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.imooc.order.utils.JsonUtil;
import com.imooc.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/20 下午 11:24
 */
@Component
@Slf4j
public class ProductInfoReceiver {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    private static String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";

    @RabbitListener(queuesToDeclare = @Queue("productInfoVoList"))
    public void process(String msg) {
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>) JsonUtil.fromJson(msg,
                new TypeReference<List<ProductInfoOutput>>() {
                });
        log.info("从队列{}接收消息:{}", "productInfoVoList", productInfoOutputList);
        //存储到redis中
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE,
                    productInfoOutput.getProductId()), String.valueOf(productInfoOutput.getProductStock()));
        }
    }
}
