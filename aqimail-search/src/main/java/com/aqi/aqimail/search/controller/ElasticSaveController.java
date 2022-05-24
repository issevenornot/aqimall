package com.aqi.aqimail.search.controller;

import com.aqi.aqimail.search.serivce.ProductSaveService;
import com.aqi.common.exception.BizCodeEnume;
import com.aqi.common.to.es.SkuEsModel;
import com.aqi.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author koi
 * @Date 2022/5/24 12:31
 * @Version 1.0
 */
@Slf4j
@RequestMapping("/search/save")
@RestController
public class ElasticSaveController {
    /**
     * 上架商品
     * */
    @Autowired
    private ProductSaveService productSaveService;
    @PostMapping("/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels){
        boolean b =false;
        try {
            b = productSaveService.productStatusUp(skuEsModels);
        }catch (Exception e){
            log.error("ElasticSaveController商品上架错误：{}",e);
            return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());
        }
        if (!b){
            return R.ok();
        }else {return R.error(BizCodeEnume.PRODUCT_UP_EXCEPTION.getCode(), BizCodeEnume.PRODUCT_UP_EXCEPTION.getMsg());}
    }
}
