package com.common.generate.javacreate.ordercenter.utils;

import org.apache.tomcat.util.buf.HexUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @ClassName: SignUtil
 * @Description: 网关层签名
 * @Author: Hu Liangzhi
 * @Date: 2022/11/11 20:18
 **/
public class SignUtil {
    private final static Charset UTF8 = StandardCharsets.UTF_8;

    public static Map<String, String> authSignHeader(String url, String body, String token) throws Exception {
        String nonce = ThreadLocalRandom.current().nextInt(99999999) + "";
        String timestamp = System.currentTimeMillis() / 1000 + "";


        String hashedRequestPayload = sha1(body.getBytes(StandardCharsets.UTF_8)); // 必须指明编码

        String canonicalRequest = "POST" + url.substring(url.indexOf(".com") + 4) + hashedRequestPayload;

        String key = (null == token) ? timestamp : token;
        String verifySign = timestamp + nonce + canonicalRequest;
//        System.out.println("签名串：" + verifySign);
        String sign = hmacSha1(key, verifySign); // token不存在时，timestamp作为密钥

        Map<String, String> signHeader = new HashMap<>();
        signHeader.put("x-sign-nonce", nonce);
        signHeader.put("x-sign-version", "1.0");
        signHeader.put("x-sign-timestamp", timestamp);
        signHeader.put("x-sign", sign);

        return signHeader;
    }


    private static String hmacSha1(String key, String msg) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(UTF8), mac.getAlgorithm());
        mac.init(secretKeySpec);
        byte[] bytes = mac.doFinal(msg.getBytes(UTF8));
        return HexUtils.toHexString(bytes);
    }

    private static String sha1(byte[] bytes) throws Exception {
        if (bytes == null || bytes.length == 0) {
            return "";
        }
        MessageDigest sha1Digest = MessageDigest.getInstance("SHA1");
        return HexUtils.toHexString(sha1Digest.digest(bytes));
    }

    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        System.out.println(set);
    }
}
