package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.ordercenter.dto.ElkDTO;

import java.util.List;

/**
 * @author xialei
 * @date 2023/5/13 10:15
 */
public class aaaa {








    public static void main(String[] args){
        String json ="[\n" +
                "        {\n" +
                "            \"orderId\": 5188886528249763624,\n" +
                "            \"orderNo\": \"720313200013-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188719627196372779,\n" +
                "            \"orderNo\": \"720313200002-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188414512778385197,\n" +
                "            \"orderNo\": \"720313100006\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188455909619341096,\n" +
                "            \"orderNo\": \"720313100010-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188753780408000137,\n" +
                "            \"orderNo\": \"720313200005-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188692269085957765,\n" +
                "            \"orderNo\": \"720313200001\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188804344265252490,\n" +
                "            \"orderNo\": \"720313200011-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188510861234476840,\n" +
                "            \"orderNo\": \"720313100013-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188804345645178498,\n" +
                "            \"orderNo\": \"720313200011-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5187849477040316032,\n" +
                "            \"orderNo\": \"720312900023-3\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188428055695267624,\n" +
                "            \"orderNo\": \"720313100007\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188788420815820581,\n" +
                "            \"orderNo\": \"720313200009-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5187741900700063531,\n" +
                "            \"orderNo\": \"720312900016-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188410563045039750,\n" +
                "            \"orderNo\": \"720313100005-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 7010002304211116936,\n" +
                "            \"orderNo\": \"720311100007-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188844494776375082,\n" +
                "            \"orderNo\": \"720313200012\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188753781443993228,\n" +
                "            \"orderNo\": \"720313200005-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188522648067577643,\n" +
                "            \"orderNo\": \"720313100014-3\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188486311968970542,\n" +
                "            \"orderNo\": \"720313100011\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188522646918338342,\n" +
                "            \"orderNo\": \"720313100014-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188510862366938925,\n" +
                "            \"orderNo\": \"720313100013-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188522645697795883,\n" +
                "            \"orderNo\": \"720313100014-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188455908282146443,\n" +
                "            \"orderNo\": \"720313100010-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188410564114587272,\n" +
                "            \"orderNo\": \"720313100005-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188788421788899107,\n" +
                "            \"orderNo\": \"720313200009-2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188719625662045838,\n" +
                "            \"orderNo\": \"720313200002-1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"orderId\": 5188886529341070980,\n" +
                "            \"orderNo\": \"720313200013-2\"\n" +
                "        }\n" +
                "    ]";

        StringBuilder stringBuilder =new StringBuilder();
        List<ElkDTO> elkDTOS = JSON.parseArray(json, ElkDTO.class);
        for (ElkDTO elkDTO : elkDTOS) {
            stringBuilder.append("\"").append(elkDTO.getOrderId()).append("\"").append(" OR ");
        }
        System.out.println(elkDTOS.size());

        System.out.println(stringBuilder);
    }
}
