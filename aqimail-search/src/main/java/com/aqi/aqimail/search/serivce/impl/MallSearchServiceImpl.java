package com.aqi.aqimail.search.serivce.impl;

import com.aqi.aqimail.search.config.AqiMallElasticSearchConfig;
import com.aqi.aqimail.search.constant.EsConstant;
import com.aqi.aqimail.search.serivce.MallSearchService;
import com.aqi.aqimail.search.vo.SearchParam;
import com.aqi.aqimail.search.vo.SearchResult;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.NestedQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author koi
 * @Date 2022/6/4 11:22
 * @Version 1.0
 */
@Service
public class MallSearchServiceImpl implements MallSearchService {
    private final static String separator = "-";
    @Autowired
    private RestHighLevelClient client;
    @Override
    public SearchResult search(SearchParam param) {
        //1、动态构建出要查询的DSL语句
        SearchResult searchResult = null;
        //准备检索请求
        SearchRequest searchRequest = buildSearchRequest(param);

        try {
            //执行检索请求
            SearchResponse response = client.search(searchRequest,AqiMallElasticSearchConfig.COMMON_OPTIONS);
            //分析响应数据封装成我们需要的格式
            SearchResult result = buildSearchResult(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 分析响应数据封装成我们需要的格式
     * 构建结果数据
     * */
    private SearchResult buildSearchResult(SearchResponse response) {
        return null;
    }

    /**
     * 准备检索请求
     * 模糊匹配 过滤（按照属性、分类、品牌、价格区间、库存），排序，分页，高亮，聚合分析
     * @param param
     */
    private SearchRequest buildSearchRequest(SearchParam param) {
        //构建DSL语句
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        /**
         * 查询：模糊匹配 过滤（按照属性、分类、品牌、价格区间、库存）
         * */
        //1 构建bool - query
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        //1.1 must 模糊匹配
        if (StringUtils.hasLength(param.getKeyword())){
            boolQuery.must(QueryBuilders.matchQuery("skuTitle",param.getKeyword()));
        }
        //1.2 bool - filter 按照三级分类ID查询
        if (param.getCatalog3Id() != null){
            boolQuery.filter(QueryBuilders.termQuery("catalogId",param.getCatalog3Id()));
        }

        //1.2 bool - filter 按照品牌id查
        if (param.getBrandId() != null && param.getBrandId().size() > 0){
            boolQuery.filter(QueryBuilders.termsQuery("brandId",param.getBrandId()));
        }
        //1.2 bool - filter 按照属性查
        if (param.getAttrs() != null && param.getAttrs().size() > 0){
            for (String attrStr: param.getAttrs()) {
                BoolQueryBuilder nestedBoolQuery = QueryBuilders.boolQuery();
                String[] s = attrStr.split("_");
                String attrId = s[0];
                String[] attrValues = s[1].split(":");
                nestedBoolQuery.must(QueryBuilders.termQuery("attrs.attrId",attrId));
                nestedBoolQuery.must(QueryBuilders.termsQuery("attrs.attrValue",attrValues));
                //每一个都得生成一个nested查询
                NestedQueryBuilder nestedQuery = QueryBuilders.nestedQuery("attrs", null, ScoreMode.None);
                boolQuery.filter(nestedQuery);
            }

        }

        //1.2 bool - filter 按照是否拥有库存查询
        boolQuery.filter(QueryBuilders.termsQuery("hasStock",param.getHasStock() == 1));

        //1.2 bool - filter 按照价格区间
        if (StringUtils.hasLength(param.getSkuPrice())){
            RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("skuPrice");
            String[] s = param.getSkuPrice().split(separator);
            if (s.length == 2){
                //区间
                rangeQuery.gte(s[0]).lte(s[1]);
            }else if (s.length == 1){
                if (param.getSkuPrice().startsWith(separator)){
                    rangeQuery.lte(s[0]);
                }
                if (param.getSkuPrice().endsWith(separator)){
                    rangeQuery.gte(s[0]);
                }
            }
        }
        //把以前所有的条件都拿来进行封装
        sourceBuilder.query(boolQuery);

        /**
         * 排序，分页，高亮
         * */

        /**
         * 聚合分析
         * */
        SearchRequest searchRequest = new SearchRequest(new String[]{EsConstant.PRODUCT_INDEX}, sourceBuilder);
        return null;
    }
}
