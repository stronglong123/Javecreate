package com.common.generate.javacreate.utils;

import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.exception.BusinessException;
import com.common.generate.javacreate.enums.BasicClassType;
import com.common.generate.javacreate.enums.BusinessCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 接口校验工具类
 *
 * @author Hu Liangzhi
 * @Date:2020年7月10日 上午10:55:03
 */
public class AuthUtil {

    private static final Logger LOG = LoggerFactory.getLogger(AuthUtil.class);
    private static final String UNKNOWN = "unknown";

    private AuthUtil() {
    }

    public static String getAuth(String appSecret, Class<?> aClass, Object arg) {
        Field[] fields = aClass.getDeclaredFields();
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(arg));
        StringBuilder buffer = new StringBuilder();
        List<Field> fieldList = new ArrayList<>(Arrays.asList(fields));
        List<Field> sortedFieldList = fieldList.stream().sorted(Comparator.comparing(Field::getName)).collect(Collectors.toList());
        for (Field field : sortedFieldList) {
            String name = field.getName();
            if (jsonObject.get(name) != null) {
                parseFieldInBuffer(buffer, jsonObject.get(name));
            }
        }
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        String signInit = buffer.toString();
        LOG.info("签名初始拼接信息:" + signInit);
        String sign = MD5Utils.getMD5(signInit + appSecret);
        LOG.info("签名最终信息:" + sign);
        return sign;
    }

    public static String getAuth(String appSecret, Object arg) {
        StringBuilder buffer = new StringBuilder();
        parseFieldInBuffer(buffer, arg);
        if (buffer.length() > 0) {
            buffer.deleteCharAt(buffer.length() - 1);
        }
        LOG.info("签名初始拼接信息:" + buffer.toString());
        String sign = MD5Utils.getMD5(buffer.toString() + appSecret);
        LOG.info("签名最终信息:" + sign);
        return sign;
    }

    /**
     * 解析参数
     * @param buffer
     * @param arg
     */
    public static void parseFieldInBuffer(StringBuilder buffer, Object arg) {
        if (null != arg && !"".equals(arg)) {
            if (isBasicClassType(arg)) {// 基本、包装类型
                if(arg instanceof BigDecimal){
                    /**如果是小数，则去掉小数后面多余的0，如果是整数，则小数点默认添加一个0*/
                    BigDecimal arg1 = (BigDecimal) arg;
                    String retStr = arg1.stripTrailingZeros().toPlainString();
                    if(retStr.indexOf(".")==-1) {
                        retStr = retStr+".0";
                    }
                    BigDecimal decimal = new BigDecimal(retStr);
                    buffer.append(decimal);
                }else {
                    buffer.append(arg);
                }
                buffer.append("|");
            } else {
                // 非基本、包装类型类型，直接转成json字符串
                // 抽出数组类型
                if (arg instanceof List || arg instanceof Set) {
                    @SuppressWarnings("unchecked")
                    List<Object> itmes = (List<Object>)arg;
                    Iterator<Object> itr = itmes.iterator();
                    while (itr.hasNext()) {
                        parseFieldInBuffer(buffer, itr.next());
                    }
                    return;
                }

                setObjInBuffer(buffer, arg);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void setObjInBuffer(StringBuilder buffer, Object arg) {
        Map<String, Object> paraMap = null;
        if (arg instanceof LinkedHashMap) {
            paraMap = (LinkedHashMap<String, Object>) arg;
        } else if (arg instanceof Map) {
            paraMap = (Map) arg;
        } else {
            paraMap = MyBeanUtil.transBean2TreeMap(arg);
        }

        String[] keys = paraMap.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        for (String key : keys) {
            parseFieldInBuffer(buffer, paraMap.get(key));
        }
    }

    private static boolean isBasicClassType(Object obj) {
        if (null == obj) {
            return false;
        }
        for (BasicClassType basicClassType : BasicClassType.values()) {
            if (obj.getClass().getName().equals(basicClassType.getType())) {
                return true;
            }
        }
        return false;
    }


    public static String getSignatureFromRequestContext() {
        return getSignatureFromRequestContext("signature");
    }

    public static String getSignatureFromRequestContext(String signName) {
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String signature = request.getHeader(signName);
        if (StringUtils.isEmpty(signature)) {
            throw new BusinessException("签名不存在！", BusinessCodeEnum.UNAUTHORIZED.code);
        }
        return signature;
    }

    public static String getTokenFromRequestContext() {
        HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new BusinessException("token不存在！",BusinessCodeEnum.UNAUTHORIZED.code);
        }
        return token;
    }

    public static Map<String, String> getQueryMap(HttpServletRequest request, String charset) {
        Map<String, String> queryMap = new HashMap<>();
        String queryString = request.getQueryString();
        String[] params = queryString.split("&");

        try {
            for (int i = 0; i < params.length; ++i) {
                String[] kv = params[i].split("=");
                String key;
                if (kv.length == 2) {
                    key = URLDecoder.decode(kv[0], charset);
                    String value = URLDecoder.decode(kv[1], charset);
                    queryMap.put(key, value);
                } else if (kv.length == 1) {
                    key = URLDecoder.decode(kv[0], charset);
                    queryMap.put(key, "");
                }
            }
        } catch (IOException e) {
            LOG.error("获取appKey 和 sign 失败", e);
        }

        return queryMap;
    }

    /**
     * 获取ip地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String comma = ",";
        String localhost = "127.0.0.1";
        if (ip.contains(comma)) {
            ip = ip.split(",")[0];
        }
        if  (localhost.equals(ip))  {
            /** 获取本机真正的ip地址 */
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                LOG.error("获取IP地址错误", e);
            }
        }
        return ip;
    }

}
