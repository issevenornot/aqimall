package com.aqi.aqimail.search.serivce;

import com.aqi.aqimail.search.vo.SearchParam;
import com.aqi.aqimail.search.vo.SearchResult;

/**
 * @Author koi
 * @Date 2022/6/4 11:21
 * @Version 1.0
 */
public interface MallSearchService {
    /**
     * 检索的所有参数 返回检索的结果 里面包含页面所有信息
     * */
    SearchResult search(SearchParam param);
}
