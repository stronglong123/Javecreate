package com.common.generate.javacreate.test;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;

import javax.sound.midi.Soundbank;
import java.beans.BeanInfo;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Handler;

/**
 * @author xialei
 * @date 2021/4/29 21:37
 */
public class test1 {


    public static String getText(){
        String json ="[\n" +
                "    {\n" +
                "        \"上海\": 4041,\n" +
                "        \"临汾\": 7051,\n" +
                "        \"兰州\": 7131,\n" +
                "        \"南昌\": 1011,\n" +
                "        \"合肥\": 4001,\n" +
                "        \"向塘\": 1011,\n" +
                "        \"哈尔滨\": 7111,\n" +
                "        \"大同\": 7231,\n" +
                "        \"大理\": 1191,\n" +
                "        \"太原\": 7041,\n" +
                "        \"常德\": 1051,\n" +
                "        \"怀化\": 1121,\n" +
                "        \"拉萨市\": 999219,\n" +
                "        \"昆明\": 1191,\n" +
                "        \"武汉\": 1031,\n" +
                "        \"海口\": 1211,\n" +
                "        \"澄迈\": 1211,\n" +
                "        \"石家庄\": 7001,\n" +
                "        \"芜湖\": 4121,\n" +
                "        \"衡阳\": 1101,\n" +
                "        \"西宁\": 7691,\n" +
                "        \"赣州\": 1091,\n" +
                "        \"银川\": 7516,\n" +
                "        \"长春\": 7141,\n" +
                "        \"长沙\": 1001,\n" +
                "        \"阿里地区\": 9981\n" +
                "    },\n" +
                "    {\n" +
                "        \"上海\": 4041,\n" +
                "        \"临汾\": 7051,\n" +
                "        \"佛山\": 1021,\n" +
                "        \"兰州\": 7131,\n" +
                "        \"包头\": 7581,\n" +
                "        \"南京\": 4021,\n" +
                "        \"南宁\": 1141,\n" +
                "        \"南昌\": 1011,\n" +
                "        \"厦门\": 4291,\n" +
                "        \"合肥\": 4001,\n" +
                "        \"呼和浩特\": 7211,\n" +
                "        \"哈尔滨\": 7111,\n" +
                "        \"大同\": 7231,\n" +
                "        \"天津\": 7031,\n" +
                "        \"太原\": 7041,\n" +
                "        \"常德\": 1051,\n" +
                "        \"徐州\": 4211,\n" +
                "        \"成都\": 1171,\n" +
                "        \"拉萨市\": 999219,\n" +
                "        \"昆明\": 1191,\n" +
                "        \"杭州\": 4061,\n" +
                "        \"武汉\": 1031,\n" +
                "        \"沈阳\": 7061,\n" +
                "        \"泉州\": 4571,\n" +
                "        \"济南\": 4011,\n" +
                "        \"淮安\": 4651,\n" +
                "        \"石家庄休食\": 7006,\n" +
                "        \"石家庄酒饮\": 7001,\n" +
                "        \"福州\": 4051,\n" +
                "        \"芜湖\": 4121,\n" +
                "        \"苏州\": 4191,\n" +
                "        \"茂名\": 1681,\n" +
                "        \"荆州\": 1591,\n" +
                "        \"贵阳\": 1131,\n" +
                "        \"赣州\": 1091,\n" +
                "        \"郑州\": 4031,\n" +
                "        \"重庆\": 1181,\n" +
                "        \"金华\": 4731,\n" +
                "        \"长春\": 7141,\n" +
                "        \"阿里地区\": 9981,\n" +
                "        \"青岛\": 4251\n" +
                "    },\n" +
                "    {\n" +
                "        \"合肥\": 4001,\n" +
                "        \"哈尔滨\": 7111,\n" +
                "        \"安庆\": 4221,\n" +
                "        \"拉萨市\": 999219,\n" +
                "        \"武汉\": 1031,\n" +
                "        \"福州\": 4051,\n" +
                "        \"芜湖\": 4121,\n" +
                "        \"连云港\": 4671,\n" +
                "        \"阿里地区\": 9981\n" +
                "    }\n" +
                "]";
        return json;
    }



    public static void main(String[] args){
//        Map<String,String> map =new HashMap<>();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println("有值");
//        }

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println(i);
        }

//        System.out.println(DateUtil.beginOfDay(new Date()));
//        System.out.println(DateUtil.endOfDay(new Date()));

//        String str ="";
//        System.out.println(StringUtils.isNumeric(str));
//        if(StringUtils.isNumeric("")){
//            System.out.println(Long.valueOf(str));
//        }

//        String text ="16800001198513,1198\n" +
//                "16800005831135,5831\n" +
//                "40000001548114,1548\n" +
//                "40000002257189,2257\n" +
//                "40000011177290,11177\n" +
//                "40000025226449,25226 \n" +
//                "71100001542278,1542\n" +
//                "71100001840110,1840\n" +
//                "71100038136458,38136 \n" +
//                "71100083356891,83356 \n" +
//                "71100138217725,138217\n" +
//                "4867681516293513043,370265\n" +
//                "4902119644662319944,417014\n" +
//                "4903302845124561758,6021\n" +
//                "4911289297360599187,74902";
//
//        Map<Long,Long> map =new HashMap<>();
//        String[] splits = text.split("\n");
//        for (String split : splits) {
//            String[] s = split.split(",");
//            map.put(Long.valueOf(s[0].trim()),Long.valueOf(s[1].trim()));
//        }
//        System.out.println(JSON.toJSONString(map));
    }


    public static void parseArray(){
        String text = getText();
        List<Map> list = JSON.parseArray(text, Map.class);
        Set<String> set =new HashSet<>();
        list.stream().forEach(it->{
            for (Object value : it.values()) {
                set.add(value.toString());
            }
        });

        System.out.println(JSON.toJSONString(set));
    }
}
