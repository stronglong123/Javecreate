package com.common.generate.javacreate.test.transferNote;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.utils.HttpClientUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xialei
 * @date 2021/4/4 17:04
 */
public class transferNoteCancelService {

    private static final String token = "2a451b0e-8ce4-43ca-ac05-660aa14ef2e0";


    private static final String baseUrl = "http://openapi.pre.yijiupi.com/openapi/";

    public static void main(String[] args){
//        cancelTransferNote("XC201912300029",107);
//        traceQuery();
        BigDecimal num =new BigDecimal(1.000100);
        BigDecimal tow =new BigDecimal(0.1);
        System.out.println((num.subtract(tow)).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString());
    }




    public static void cancelTransferNote(String businessNo,Integer orgId) {
        String url ="/erpAllotOrder/cancleOrder/"+businessNo+"/"+orgId;
        url = baseUrl + url;
        String resultstr = HttpClientUtils.doGetWithToken(token, url);
        System.out.println(resultstr);
    }

    public static void traceQuery() {
        String url="http://openapi.pre.yijiupi.com/openapi//oms/order/traceQuery";
        String body="{\"omsOrderId\":998000210402178288,\"type\":1}";
        String resultstr = HttpClientUtils.doPostWithToken(token, url, body);
        System.out.println(resultstr);
    }
}
