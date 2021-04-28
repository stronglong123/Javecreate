package com.common.generate.javacreate.utils;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.baidu.aip.ocr.AipOcr;
import com.common.generate.javacreate.model.BaiduOrcResultDTO;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2021/1/16 15:30
 */
public class BaiduBodyUtil {

    //设置APPID/AK/SK
    public static final String APP_ID = "24081762";
    public static final String API_KEY = "j8wuXRvbRBtWuNkGW5yo3ilL";
    public static final String SECRET_KEY = "H0RopfXr5KWU9auB4rYkhMIY6CKGNdWc";

    private static AipBodyAnalysis client = new AipBodyAnalysis(APP_ID, API_KEY, SECRET_KEY);


    public static String bodyAnalysis(MultipartFile image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        JSONObject res = client.bodyAnalysis(file, options);
        return res.toString();
    }

    public static String bodyAttr(MultipartFile image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        JSONObject res = client.bodyAttr(file, options);
        return res.toString();
    }


    public static String bodyNum(MultipartFile image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        JSONObject res = client.bodyNum(file, options);
        return res.toString();
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


}
