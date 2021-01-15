package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.authutils.AuthUtil;
import com.common.generate.javacreate.authutils.MD5Utils;
import com.common.generate.javacreate.test.dto.OrderQueryDTO;
import com.common.generate.javacreate.test.dto.OrderSendSyncDTO;
import com.common.generate.javacreate.test.dto.ThirdSSCancelOrderDTO;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.HttpUtil;
import com.common.generate.javacreate.utils.Md5Utils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2020/8/12 13:55
 */
public class Test {


    private static String matchKey(String name,String key){
        Pattern bugNumber = Pattern.compile("\\s*([0-9]+)(?i)" + key);
        // find the bug#
        Matcher matcher = bugNumber.matcher(name);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }


    public static void main(String[] args){
        System.out.println(DateUtils.getTimeByDate("2021-01-10 15:10:00"));
        System.out.println(DateUtils.getTimeByDate("2021-01-10 15:40:00"));

//        System.out.println(String.valueOf(null));
//        BigDecimal skuPrice =BigDecimal.ONE;
//        Long price = skuPrice == null ? 0L : (skuPrice.multiply(BigDecimal.valueOf(100)).longValue());
//        System.out.println(price);


//        List<String> list =new ArrayList<>();
//        System.out.println(list.get(0));
//        String subject ="茅台天朝上品贵人53度500ml（1*6）";
//        String key = matchKey(subject, "度");
//        System.out.println(key);
//
////        String subject = "1234Bug- description";
//        Pattern bugNumber = Pattern.compile("\\s*([0-9]+)(?i)度");
//        // find the bug#
//        Matcher matcher = bugNumber.matcher(subject);
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }


//
//
//        Pattern p = Pattern.compile("[^0-9]+度");
//        System.out.println(p.toString());
//        Matcher m = p.matcher(name);
////        System.out.println(m.group());
//        String s1 = m.replaceAll("");
//        System.out.println(s1);
//
//
////        String kgs2 = k.replaceAll("").trim();
//////        System.out.println(kgs2);
////        Pattern pattern = Pattern.compile("\\d+度");
////        Matcher matcher = pattern.matcher(name);
////        System.out.println(name.replaceAll("\\d+度",""));
////        String all = matcher.replaceAll("");// 不属于任何匹配的字符被直接添加到结果字符串
////        System.out.println("phone:" + all);
////        String phoneString = "哈哈,1388888额9999";
////        String s = Pattern.compile("[^0-9]").matcher(name).replaceAll("");
////        System.out.println(s);
//
//
////        String str = "hello8023.1314world"; //要截取的字符串
////        Match m = Regex.Match(str, "\\d+(\\.\\d+){0,1}");
////        double.TryParse(m.Groups[0].ToString(), out d);
////        Console.WriteLine(d);
////        Console.ReadKey();
//
//        String s = "A876X";
//// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
//// 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
//        Pattern pattern = Pattern.compile("(\\d)[^\\d]*$");
//        Matcher matcher = pattern.matcher(name);
//        if(matcher.find())
//            System.out.println(matcher.group(1));
////        REGEXP_REPLACE(REGEXP_SUBSTR('12月最低消费20元','[0-9]+元'),'[^0-9]')
    }

    /**
     * 获取订单
     *
     * @param appSecret
     * @param appKey
     */
    public void test() {
        String url = "https://cashew.3songshu.com/api/yijiupi/refund/apply";
        String json = "{\"businessNo\":\"998002201102150613\"}";
//        ThirdSSCancelOrderDTO cancelOrderDTO =  JSON.parseObject(json, ThirdSSCancelOrderDTO.class);
        ThirdSSCancelOrderDTO cancelOrderDTO =new ThirdSSCancelOrderDTO();
        cancelOrderDTO.setOrderNo("10101011111");
        cancelOrderDTO.setBuyerNick("测试");
        cancelOrderDTO.setApplyTime(DateUtils.getCurrentTime());
        cancelOrderDTO.setNum(1);
        cancelOrderDTO.setRefundMoney("1");
        cancelOrderDTO.setRefundId("10101011111");
        cancelOrderDTO.setSourceName("易久批");
        cancelOrderDTO.setSign(getSign(cancelOrderDTO).toUpperCase());
        System.out.println(JSON.toJSONString(cancelOrderDTO));
        try {
            String post = HttpUtil.post(url, JSON.toJSONString(cancelOrderDTO));
            System.out.println("订单详情获取：" + post);
        } catch (Exception e) {
            System.out.println("请求失败:" + e);
        }
    }

    private String getSign(ThirdSSCancelOrderDTO cancelOrderDTO) {
        StringBuilder buffer = new StringBuilder();
        AuthUtil.parseFieldInBuffer(buffer, cancelOrderDTO, "");
        String signInit = cancelOrderDTO.getOrderNo() + buffer.toString() + cancelOrderDTO.getOrderNo();
        System.out.println("签名初始拼接信息:" + signInit);
        String sign = MD5Utils.getMD5(signInit);
        System.out.println("签名最终信息:" + sign);
        return sign;
    }

    public static void testFlatMap() {

        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");

        List<List<String>> playersInWorldCup2016 = new ArrayList<>();
        playersInWorldCup2016.add(teamIndia);
        playersInWorldCup2016.add(teamAustralia);
        playersInWorldCup2016.add(teamEngland);
        playersInWorldCup2016.add(teamNewZeland);
        playersInWorldCup2016.add(teamSouthAfrica);
        playersInWorldCup2016.add(teamWestIndies);
        playersInWorldCup2016.add(teamSriLanka);
        playersInWorldCup2016.add(teamPakistan);

        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();

        for (List<String> team : playersInWorldCup2016) {
            for (String name : team) {
                listOfAllPlayers.add(name);
            }
        }

        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);

        // Now let's do this in Java 8 using FlatMap
        List<String> flatMapList = playersInWorldCup2016.stream()
                .flatMap(pList -> pList.stream())
                .collect(Collectors.toList());

        System.out.println("List of all Players using Java 8 flatMap");
        System.out.println(flatMapList);
    }
}
