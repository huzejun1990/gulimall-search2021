package com.dream.gulimall.search.config;

import jdk.nashorn.internal.parser.Token;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.elasticsearch.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: huzejun
 * @Date: 2021/1/10 21:52
 */

/**
 * 1.导入依赖
 * 2.编写配置,给容器中注入一个RestHighLevelClient
 * 3.参照api地址 https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high-getting-started-initialization.html
 */
@Configuration
public class GulimallElasticSearchConfig {

    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();;
//        builder.addHeader("Authorization","Bearer"+ Token);
        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient esRestClient(){

        RestClientBuilder builder = null;

        // final String hostname, final int port, final String scheme
        builder = RestClient.builder(new HttpHost("192.168.31.61", 9200, "http"));
        RestHighLevelClient client = new RestHighLevelClient(builder);
/*        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.31.61", 9200, "http")));*/
        return client;
    }
}
