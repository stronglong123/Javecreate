package com.common.generate.javacreate.ordercenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.common.generate.javacreate.model.text.TextDTO;
import com.common.generate.javacreate.ordercenter.dto.SpiDTO;
import com.common.generate.javacreate.ordercenter.dto.eventaudit.EventPublishAuditDocumentDTO;
import com.common.generate.javacreate.utils.DateUtils;
import com.common.generate.javacreate.utils.ExcelUtils;
import com.google.common.collect.Lists;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/8/1 13:44
 */
public class testaa {


    public static void main(String[] args){
        String json ="[\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304010301710,\n" +
                "            \"payAmount\": 584.13\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304012002158,\n" +
                "            \"payAmount\": 216.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304021202440,\n" +
                "            \"payAmount\": 432.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304022002711,\n" +
                "            \"payAmount\": 316.54\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304030802825,\n" +
                "            \"payAmount\": 216.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304030902827,\n" +
                "            \"payAmount\": 647.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304031102942,\n" +
                "            \"payAmount\": 199.2\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304031503074,\n" +
                "            \"payAmount\": 863.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304031903210,\n" +
                "            \"payAmount\": 367.98\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304032103270,\n" +
                "            \"payAmount\": 893.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304032303315,\n" +
                "            \"payAmount\": 1511.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304040903376,\n" +
                "            \"payAmount\": 232.5\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304040903399,\n" +
                "            \"payAmount\": 95.5\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4000002304041103476,\n" +
                "            \"payAmount\": 256.5\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4760002304012068101,\n" +
                "            \"payAmount\": 278.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 4760002304012268102,\n" +
                "            \"payAmount\": 572.5\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 5174987245526194727,\n" +
                "            \"payAmount\": 182.3\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 5174998208497326633,\n" +
                "            \"payAmount\": 5694.0\n" +
                "        },\n" +
                "        {\n" +
                "            \"collectionTime\": 1680775108017,\n" +
                "            \"orderId\": 5175077341583645225,\n" +
                "            \"payAmount\": 278.0\n" +
                "        }\n" +
                "    ]";
        List<Trace> traces = JSON.parseArray(json, Trace.class);
        List<Long> orderIds =new ArrayList<>();

//        List<Trace> sorted = traces.stream().sorted(Comparator.comparing(it -> it.getCreateTime())).collect(Collectors.toList());
        for (Trace trace : traces) {
            System.out.println(trace.toString());
            orderIds.add(trace.getOrderId());
        }
        System.out.println(JSON.toJSONString(orderIds));
    }








    public static void main2(String[] args) {
        // 1.创建表达式解析器
        ExpressionParser parser = new SpelExpressionParser();
        // 2.执行表达式,取得表达式结果
        String expressionStr = "'Hello, Spel' + #ending + '\n' + " +
                "'Fighting, ' + #mobileMap['huawei'] + #ending + '\n' + " +
                "'Fly, ' + #collectCar[0] + #ending + '\n' + " +
                " new String(#number matches '\\d+')";
        Expression expression = parser.parseExpression(expressionStr);

        // 3.创建变量上下文,设置变量
        EvaluationContext evaluationContext = new StandardEvaluationContext();
        // 变量1,普通字符串
        evaluationContext.setVariable("ending", "!");
        // 变量2,Map类型
        Map<String, String> mobileMap = new HashMap<>();
        mobileMap.put("huawei", "华为");
        mobileMap.put("xiaomi", "小米");
        evaluationContext.setVariable("mobileMap", mobileMap);
        // 变量3,Collection类型
        evaluationContext.setVariable("collectCar", Lists.newArrayList("比亚迪", "红旗", "吉利"));
        // 变量4,POJO对象
//        evaluationContext.setVariable("user", new User("饱饱"));
        // 变量5,匹配正则表达式
        evaluationContext.setVariable("number", 142857);

        // 4.传入变量上下文,通过表达式对象取得结果
        String result = expression.getValue(evaluationContext, String.class);
        System.out.println(result);
    }

    public static void main3(String[] args) throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\spi.xlsx";
        List<SpiDTO> spiDTOS = ExcelUtils.readExcelToEntity(SpiDTO.class, filePath, "spi.xlsx");
        List<Long> spiIds =new ArrayList<>();
        List<Long> spiProviderIds =new ArrayList<>();

        for (SpiDTO spiDTO : spiDTOS) {
            if(spiDTO.getSpiId()!=null){
                spiIds.add(spiDTO.getSpiId());
            }
            if(spiDTO.getSpiProvideId()!=null){
                spiProviderIds.add(spiDTO.getSpiProvideId());
            }
        }
        System.out.println(spiIds.size());
        System.out.println(spiProviderIds.size());

        StringBuilder spiBuilder =new StringBuilder();
        spiBuilder.append("delete from ordercenter_management.spi_manage where Id in ( ");
        for (Long spiId : spiIds) {
            spiBuilder.append(spiId).append(",");
        }
        spiBuilder.append(");");
        StringBuilder spiProviderBuilder =new StringBuilder();
        spiProviderBuilder.append("delete from ordercenter_management.spi_provider_manage where Id in ( ");

        for (Long spiProviderId : spiProviderIds) {
            spiProviderBuilder.append(spiProviderId).append(",");
        }
        spiProviderBuilder.append(");");


        System.out.println(spiBuilder.toString());
        System.out.println(spiProviderBuilder.toString());

    }


}

class Trace {
    private Long business_Id;
    private Date createTime;
    private String description;
    private Date lastUpdateTime;
    private Integer mouldShowType;
    private String tag;

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBusiness_Id() {
        return business_Id;
    }

    public void setBusiness_Id(Long business_Id) {
        this.business_Id = business_Id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getMouldShowType() {
        return mouldShowType;
    }

    public void setMouldShowType(Integer mouldShowType) {
        this.mouldShowType = mouldShowType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Trace{" +
                "business_Id=" + business_Id +
                ", createTime=" + DateUtils.date2String(createTime) +
                ", description='" + description + '\'' +
                ", lastUpdateTime=" + DateUtils.date2String(lastUpdateTime) +
                ", mouldShowType=" + mouldShowType +
                ", tag='" + tag + '\'' +
                '}';
    }
}
