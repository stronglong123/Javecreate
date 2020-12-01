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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2020/8/12 13:55
 */
public class Test {
    public static void main(String[] args){
//        List<OrderSendSyncDTO> list =new ArrayList<>();
//        String s = Md5Utils.encrytMD5("123456");
//        System.out.println(s);
//        String json ="{\"pageSize\":\"10\",\"currentPage\":\"1\",\"orderCreateTimeStart\":\"1602604800000\",\"orderCreateTimeEnd\":\"1602518400000\",\"states\":[5]}";
//        OrderQueryDTO permissionDTO = JSON.parseObject(json, OrderQueryDTO.class);
//        System.out.println(JSON.toJSONString(permissionDTO));
//        AuthUtil.getAuth("1234", OrderQueryDTO.class,permissionDTO);
        Test test = new Test();
        test.test();


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
