package com.imooc.product.controller;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gexiao
 * @date 2018/12/06 下午 10:16
 */
@RestController
public class ServerController {

    @Autowired
    private ProductService productService;

    @GetMapping("/msg")
    public String msg(){
        return "this is product msg 2";
    }



}
