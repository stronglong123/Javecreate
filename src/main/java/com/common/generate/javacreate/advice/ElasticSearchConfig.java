package com.common.generate.javacreate.advice;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xialei
 * @date 2021/10/27 11:45
 */

@Configuration
public class ElasticSearchConfig {
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private Integer port;
    @Value("${elasticsearch.scheme}")
    private String scheme;
    @Value("${elasticsearch.connect-timeout}")
    private Integer connectTimeout;

    public static final RequestOptions COMMON_OPTIONS;

    static {
        // RequestOptions类保存了请求的部分，这些部分应该在同一个应用程序中的许多请求之间共享。
        // 创建一个singqleton实例，并在所有请求之间共享它。可以设置请求头之类的一些配置
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        // builder.addHeader("Authorization", "Bearer " + TOKEN);
        // builder.setHttpAsyncResponseConsumerFactory(
        //         new HttpAsyncResponseConsumerFactory
        //                 .HeapBufferedResponseConsumerFactory(30 * 1024 * 1024 *1024));
        COMMON_OPTIONS = builder.build();
    }

    //创建ES实例
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, scheme
        )).setRequestConfigCallback(requestBuilder -> requestBuilder.setConnectTimeout(connectTimeout)
        ));
    }
}
