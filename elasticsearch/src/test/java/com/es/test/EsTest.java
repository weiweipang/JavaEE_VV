package com.es.test;

import com.elasticsearch.ElasticsearchApplication;
import com.elasticsearch.config.ElasticsearchConfig;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest(classes = ElasticsearchApplication.class)
@RunWith(SpringRunner.class)
public class EsTest {

    @Autowired
    RestHighLevelClient client;

    @Test
    public void getClient() {
        System.out.println(client);
    }

    //测试存储数据到ES
    @Test
    public void saveData() throws IOException {
        //构造参数传入索引名称
        IndexRequest indexRequest = new IndexRequest("users");
        //设置文档id
        indexRequest.id("1");
        //最常用的方式：直接传json过去
        String jsonString = "{" +
                "\"user\":\"kimchy\"," +
                "\"postDate\":\"2013-01-30\"," +
                "\"message\":\"trying out Elasticsearch\"" +
                "}";
        //构造好保存数据的请求
        indexRequest.source(jsonString, XContentType.JSON);

        //通过client有两种保存方式
        //1、同步方式
        //IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

        IndexResponse index = client.index(indexRequest, ElasticsearchConfig.COMMON_OPTIONS);
        System.out.println(index);


        //2、异步方式
        //client.indexAsync(request, RequestOptions.DEFAULT, listener);

        //异步回调
        /*   listener = new ActionListener<IndexResponse>() {
                @Override
                public void onResponse(IndexResponse indexResponse) {

                }

                @Override
                public void onFailure(Exception e) {

                }
            };
        */




    }
}
