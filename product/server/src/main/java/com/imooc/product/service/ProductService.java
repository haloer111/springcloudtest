package com.imooc.product.service;

import com.imooc.product.common.DecreaseStockInput;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> cartDTOList);
}
