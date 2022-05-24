package com.aqi.aqimail.search.serivce;

import com.aqi.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @Author koi
 * @Date 2022/5/24 12:35
 * @Version 1.0
 */
public interface ProductSaveService {
    Boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;
}
