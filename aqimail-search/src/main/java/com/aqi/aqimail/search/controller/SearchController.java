package com.aqi.aqimail.search.controller;

import com.aqi.aqimail.search.serivce.MallSearchService;
import com.aqi.aqimail.search.vo.SearchParam;
import com.aqi.aqimail.search.vo.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author koi
 * @Date 2022/6/4 11:02
 * @Version 1.0
 */
@Controller
public class SearchController {

    @Autowired
    private MallSearchService mallSearchService;
    @GetMapping("/list.html")
    public String listPage(SearchParam param){

        //根据传递来的页面的查询参数，去es检索商品
        SearchResult result = mallSearchService.search(param);
        return "list";
    }
}
