package com.common.generate.javacreate.test;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xialei
 * @date 2020/6/3 14:52
 */
public class TextUtil {


    public static void main(String[] args) throws Exception {
        System.out.println(getData());
    }


    public static String getData() throws Exception {
//        ClassPathResource classPathResource = new ClassPathResource("test/data.txt");
//        InputStream inputStream =classPathResource.getInputStream();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("tmp/data.txt");
        StringBuilder sb = new StringBuilder();
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

}

