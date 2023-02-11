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
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670297950000,\n" +
                "            \"description\": \"审核处理[审核通过]\",\n" +
                "            \"id\": 999006221206113905,\n" +
                "            \"lastUpdateTime\": 1670297950000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 999,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670297951000,\n" +
                "            \"description\": \"用户下单成功，订单类型为实仓代运营自营订单(仓库配送)\",\n" +
                "            \"id\": 998006221206115569,\n" +
                "            \"lastUpdateTime\": 1670297951000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670297952000,\n" +
                "            \"description\": \"货物流向(35):中心仓[拉萨休食中心仓(999219)]将货物内配到前置仓[阿里酒饮仓9981(9981)]，货物送到前置仓后，代运营仓库[山东汽车制造有限公司经销商仓库（我是真的）(99837)]的司机去前置仓取货，然后配送给客户\",\n" +
                "            \"id\": 999006221206113906,\n" +
                "            \"lastUpdateTime\": 1670297952000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 999,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670297952000,\n" +
                "            \"description\": \"内配单同步成功,仓库：拉萨休食中心仓\",\n" +
                "            \"lastUpdateTime\": 1670297952000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670297978000,\n" +
                "            \"description\": \"拉萨休食中心仓开始处理订单。订单为物流配送。订单分配到中转车次：369369369，物流公司：壹米滴答，单号：369369369，操作人：张裔譞拉萨\",\n" +
                "            \"lastUpdateTime\": 1670297978000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670297979000,\n" +
                "            \"description\": \"波次号更新成功，波次号：BC99921922120600001\",\n" +
                "            \"lastUpdateTime\": 1670297979000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670297993000,\n" +
                "            \"description\": \"运单拣货成功,拣货员:蓝色\",\n" +
                "            \"lastUpdateTime\": 1670297993000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670298012000,\n" +
                "            \"description\": \"运单第1次打印，打印批次为2022-12-06 11:40:12，操作人：张裔譞拉萨\",\n" +
                "            \"id\": 998006221206115571,\n" +
                "            \"lastUpdateTime\": 1670298012000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298012000,\n" +
                "            \"description\": \"订单打印成功。操作人：张裔譞拉萨,操作人手机号：18186660891\",\n" +
                "            \"lastUpdateTime\": 1670298012000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298031000,\n" +
                "            \"description\": \"仓管确认发货，发货批次为2022-12-06 11:40:31，车辆为【壹米滴答】369369369，司机为，手机号为,司机手机号为，装卸工为测试未雪，操作人：张裔譞拉萨\",\n" +
                "            \"lastUpdateTime\": 1670298031000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298075000,\n" +
                "            \"description\": \"中转订单,司机确认发车。操作人：张裔譞拉萨,操作人手机号：18186660891\",\n" +
                "            \"lastUpdateTime\": 1670298075000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298323000,\n" +
                "            \"description\": \"中转单确认入库【阿里酒饮仓9981】。操作人：临时外包-张裔譞阿里,操作人手机号：18186660897\",\n" +
                "            \"lastUpdateTime\": 1670298323000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298390000,\n" +
                "            \"description\": \"波次号更新成功，波次号：BC998122120600003\",\n" +
                "            \"lastUpdateTime\": 1670298390000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298390000,\n" +
                "            \"description\": \"运单调度成功\",\n" +
                "            \"lastUpdateTime\": 1670298390000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298390000,\n" +
                "            \"description\": \"订单装车，车辆为自带车，司机为test周啊橙，操作人:临时外包-张裔譞阿里\",\n" +
                "            \"lastUpdateTime\": 1670298390000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670298522000,\n" +
                "            \"description\": \"波次号更新成功，波次号：BC998122120600003，操作人：王新军\",\n" +
                "            \"id\": 999006221206113907,\n" +
                "            \"lastUpdateTime\": 1670298522000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 999,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298522000,\n" +
                "            \"description\": \"运单拣货成功,拣货员:王新军\",\n" +
                "            \"lastUpdateTime\": 1670298522000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298765000,\n" +
                "            \"description\": \"订单打印，打印次数：1\",\n" +
                "            \"lastUpdateTime\": 1670298765000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298779000,\n" +
                "            \"description\": \"代运营运单确认取货，取货批次号[fetchTaskNo]，操作人:[optUserName]临时外包-张裔譞阿里\",\n" +
                "            \"lastUpdateTime\": 1670298779000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298787000,\n" +
                "            \"description\": \"司机确认发车。操作人：配送员test周啊橙,操作人手机号：17718819999\",\n" +
                "            \"lastUpdateTime\": 1670298787000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670298788000,\n" +
                "            \"description\": \"仓管确认发货，发货批次为2022-12-06 11:53:08，车辆为，司机为test周啊橙，手机号为17718819999，装卸工为，操作人：配送员test周啊橙\",\n" +
                "            \"id\": 998006221206115572,\n" +
                "            \"lastUpdateTime\": 1670298788000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298797000,\n" +
                "            \"description\": \"订单标记为全部配送，操作人：配送员test周啊橙\",\n" +
                "            \"lastUpdateTime\": 1670298797000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298798000,\n" +
                "            \"description\": \"默认的收款方式为付款码收款。操作人：配送员test周啊橙,操作人手机号：17718819999\",\n" +
                "            \"lastUpdateTime\": 1670298798000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298802000,\n" +
                "            \"description\": \"司机更换新收款方式为现金收款。操作人：配送员test周啊橙,操作人手机号：17718819999\",\n" +
                "            \"lastUpdateTime\": 1670298802000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298803000,\n" +
                "            \"description\": \"订单收款成功，收款方式为现金收款, 收款金额为：0.03。操作人：配送员test周啊橙,操作人手机号：17718819999\",\n" +
                "            \"lastUpdateTime\": 1670298803000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670298855000,\n" +
                "            \"description\": \"oms订单完成\",\n" +
                "            \"id\": 998006221206115574,\n" +
                "            \"lastUpdateTime\": 1670298855000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298855000,\n" +
                "            \"description\": \"财务确认收款，收款时间：2022-12-06 11:54:14；操作人：配送员test周啊橙\",\n" +
                "            \"lastUpdateTime\": 1670298855000,\n" +
                "            \"mouldShowType\": 1,\n" +
                "            \"tag\": \"\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670297951000,\n" +
                "            \"description\": \"用户下单成功\",\n" +
                "            \"id\": 998006221206115570,\n" +
                "            \"lastUpdateTime\": 1670297951000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"已下单\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670297979000,\n" +
                "            \"description\": \"您的订单仓库已经开始作业\",\n" +
                "            \"lastUpdateTime\": 1670297979000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"仓库处理中\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298031000,\n" +
                "            \"description\": \"您的订单正在派送中，【配送员：，手机号：,司机手机号为】，请您耐心等待\",\n" +
                "            \"lastUpdateTime\": 1670298031000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"配送中\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298390000,\n" +
                "            \"description\": \"您的订单仓库已经开始作业\",\n" +
                "            \"lastUpdateTime\": 1670298390000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"仓库处理中\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 998422120611039126,\n" +
                "            \"createTime\": 1670298788000,\n" +
                "            \"description\": \"您的订单正在派送中，【配送员：test周啊橙，手机号：17718819999】，请您耐心等待\",\n" +
                "            \"id\": 998006221206115573,\n" +
                "            \"lastUpdateTime\": 1670298788000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"org_Id\": 998,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"配送中\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298797000,\n" +
                "            \"description\": \"您的订单全部配送，如有疑问，请联系配送员：test周啊橙\",\n" +
                "            \"lastUpdateTime\": 1670298797000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"已签收\\\"}\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"business_Id\": 999000221206117692,\n" +
                "            \"createTime\": 1670298855000,\n" +
                "            \"description\": \"您的订单已完成\",\n" +
                "            \"lastUpdateTime\": 1670298855000,\n" +
                "            \"mouldShowType\": 2,\n" +
                "            \"tag\": \"{\\\"title\\\":\\\"已签收\\\"}\"\n" +
                "        }\n" +
                "    ]";
        List<Trace> traces = JSON.parseArray(json, Trace.class);
        List<Trace> sorted = traces.stream().sorted(Comparator.comparing(it -> it.getCreateTime())).collect(Collectors.toList());
        for (Trace trace : sorted) {
            System.out.println(trace.toString());
        }
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
