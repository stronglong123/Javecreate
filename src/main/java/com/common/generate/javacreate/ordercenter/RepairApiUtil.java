package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.utils.HttpClientUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author xialei
 * @date 2022/12/2 17:41
 */
public class RepairApiUtil {

    @Value("json.url")
    private Map<String,String> urlMap;

    @SneakyThrows
    public static void main(String[] args){
        InputStream resourceAsStream = RepairApiUtil.class.getClassLoader().getResourceAsStream("json/url.json");

        System.out.println(resourceAsStream);
    }

    /**
     * 消费者查询
     * @return
     */
    public static void request(String code,String url, String body) {

//        InputStream resourceAsStream = this.getClass().getResourceAsStream("json/url.json");

        String token = "0cc792a8-c36b-4490-bef3-4df9894a6135";
        String resultstr = HttpClientUtils.doPostWithTokenAndSign(token, url, body);
        System.out.println(resultstr);
    }

}
