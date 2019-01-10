package com.imooc.order.controller;

import com.imooc.order.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gexiao
 * @date 2018/12/18 上午 01:43
 */
@RestController
@RefreshScope
public class GirlCtrl {

    @Autowired
    private GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print(){
        return "name:"+girlConfig.getName()+",age:"+girlConfig.getAge();
    }
}
