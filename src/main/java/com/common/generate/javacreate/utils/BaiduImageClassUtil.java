package com.common.generate.javacreate.utils;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;
import com.baidu.aip.imageclassify.AipImageClassify;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @author xialei
 * @date 2021/1/16 15:30
 */
public class BaiduImageClassUtil {

    //设置APPID/AK/SK
    public static final String APP_ID = "24082485";
    public static final String API_KEY = "ZAIvaAM5gPXIN7oTBDpYUGK3";
    public static final String SECRET_KEY = "FeVLLESZhmVn07VNOgWQz7WVMM7j354x";

    private static AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);


    /**
     * 通用物体识别
     * @param image
     * @return
     */
    public static String advancedGeneral(MultipartFile image) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<>();
        // 参数为本地图片二进制数组
        byte[] file = readImageFile(image);
        JSONObject res = client.advancedGeneral(file, options);
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
