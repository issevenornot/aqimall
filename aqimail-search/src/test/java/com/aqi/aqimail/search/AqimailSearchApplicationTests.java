package com.aqi.aqimail.search;

import com.alibaba.fastjson.JSON;
import com.aqi.aqimail.search.config.AqiMallElasticSearchConfig;
import lombok.Data;
import org.apache.tomcat.jni.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.Addressing;
import java.io.IOException;

@SpringBootTest
class AqimailSearchApplicationTests {

    @Autowired
    private RestHighLevelClient client;
    @Test
    void contextLoads() {
        System.out.println(client);
    }
    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1");
        User user = new User();
        String jsonString = JSON.toJSONString(user);
        indexRequest.source(jsonString, XContentType.JSON);

        IndexResponse index = client.index(indexRequest, AqiMallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);

    }
    @Data
    class User{
        private String name;
        private int age;
        private String sex;
    }

}
