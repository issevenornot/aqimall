package com.aqi.aqimail.search.serivce.impl;

import com.alibaba.fastjson.JSON;
import com.aqi.aqimail.search.config.AqiMallElasticSearchConfig;
import com.aqi.aqimail.search.constant.EsConstant;
import com.aqi.aqimail.search.serivce.ProductSaveService;
import com.aqi.common.to.es.SkuEsModel;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author koi
 * @Date 2022/5/24 12:39
 * @Version 1.0
 */
@Slf4j
@Service
public class ProductSaveServiceImpl implements ProductSaveService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public Boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException {
        //保存到es
        //1、给es中建立一个索引，product，建立映射关系
        //2、给es中保存数据
        //BulkRequest bulkRequest, RequestOptions options
        BulkRequest bulkRequest = new BulkRequest();
        for (SkuEsModel model:skuEsModels) {
            //1、构造保存请求
            IndexRequest indexRequest = new IndexRequest(EsConstant.PRODUCT_INDEX);
            indexRequest.id(model.getSkuId().toString());
            String s = JSON.toJSONString(model);
            indexRequest.source(s, XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, AqiMallElasticSearchConfig.COMMON_OPTIONS);
        //TODO 1、如果批量错误
        boolean b = bulk.hasFailures();
        List<String> collect = Arrays.stream(bulk.getItems()).map(BulkItemResponse::getId).collect(Collectors.toList());
        log.error("商品上架成功：{}",collect);
        return b;
    }

}
