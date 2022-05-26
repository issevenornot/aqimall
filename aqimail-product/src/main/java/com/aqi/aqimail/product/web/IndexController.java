package com.aqi.aqimail.product.web;

import com.aqi.aqimail.product.entity.CategoryEntity;
import com.aqi.aqimail.product.service.CategoryService;
import com.aqi.aqimail.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author koi
 * @Date 2022/5/26 18:50
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){
        //查出所有一级分类
        List<CategoryEntity> categoryEntityEList =  categoryService.getLLevel1Categorys();
        model.addAttribute("categoryEntities",categoryEntityEList);
        return "index";
    }
    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        Map<String, List<Catelog2Vo>> catalogJson = categoryService.getCatalogJson();
        return catalogJson;
    }
}
