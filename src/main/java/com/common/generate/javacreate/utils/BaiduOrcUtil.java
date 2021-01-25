package com.common.generate.javacreate.utils;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import com.common.generate.javacreate.model.BaiduOrcResultDTO;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.taobao.pac.sdk.cp.PacClient;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/1/16 15:30
 */
public class BaiduOrcUtil {

    //设置APPID/AK/SK
    public static final String APP_ID = "23550328";
    public static final String API_KEY = "pokyw3HBuyFNrUhLOlQ4TP1P";
    public static final String SECRET_KEY = "pQ5UkNN1FzUEIIIBbyXGMBwRyvdxYyhr";

    private static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);


    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
//        baseSample(client);

    }


    public static BaiduOrcResultDTO baseSample(MultipartFile image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        JSONObject res = client.basicGeneral(file, options);
        BaiduOrcResultDTO baiduOrcResultDTO = JSON.parseObject(res.toString(), BaiduOrcResultDTO.class);
        if(CollectionUtils.isNotEmpty(baiduOrcResultDTO.getWords_result())){
            String result = baiduOrcResultDTO.getWords_result().stream().filter(it -> StringUtils.isNotEmpty(it.getWords())).map(it -> it.getWords()).collect(Collectors.joining(""));
            baiduOrcResultDTO.setResult(result);
        }

        return baiduOrcResultDTO;
    }

    /**
     * InputStream转化为byte[]数组
     * @param image
     * @return
     */
    private static byte[] readImageFile(MultipartFile image){
        // 读入多个字节到字节数组中，byteread为一次读入的字节数
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        try {
            InputStream in = image.getInputStream();
            while (-1 != (n = in.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }catch (Exception e){
            throw new BusinessValidateException("图片解析失败，请重试");
        }
        return output.toByteArray();
    }


    public static void localSample(String image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");


        // 参数为本地图片路径
//        String image = "test.jpg";
        JSONObject res = client.basicGeneral(image, options);
        System.out.println(JSON.toJSONString(res));


    }


    public static void urlSample(String url) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        // 通用文字识别, 图片参数为远程url图片
        JSONObject res2 = client.basicGeneralUrl(url, options);
        System.out.println(res2.toString());
        BaiduOrcResultDTO baiduOrcResultDTO = JSON.parseObject(res2.toString(), BaiduOrcResultDTO.class);
        System.out.println(JSON.toJSONString(baiduOrcResultDTO));
    }





}
