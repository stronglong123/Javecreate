package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.ordercenter.dto.OrderTraceConfigDTO;
import com.common.generate.javacreate.ordercenter.dto.OrderTraceConfigQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/10/18 20:13
 */


@Service
public class TraceTypeManageBL {


    public static void main(String[] args){
        checkAndUpdate();
    }

    public static void checkAndUpdate(){
        String partnerCode ="YJP-OMS";
        List<OrderTraceConfigDTO> sourceTraceConfigs = findByPageTraceConfigQuery("release", partnerCode);
        List<OrderTraceConfigDTO> targetTraceConfigs = findByPageTraceConfigQuery("pre", partnerCode);

        Map<String, OrderTraceConfigDTO>  targetTraceMap = targetTraceConfigs.stream().collect(Collectors.toMap(it -> it.getTraceType() + "_" + it.getPartnerCode(), it -> it));
        Map<String, OrderTraceConfigDTO>  sourceTraceMap = sourceTraceConfigs.stream().collect(Collectors.toMap(it -> it.getTraceType() + "_" + it.getPartnerCode(), it -> it));

        for (Map.Entry<String, OrderTraceConfigDTO> entry : targetTraceMap.entrySet()) {
            OrderTraceConfigDTO targetConifg = entry.getValue();
            OrderTraceConfigDTO sourceConfig = sourceTraceMap.get(entry.getKey());
            if(!targetConifg.equals(sourceConfig)){
                sourceConfig.setId(targetConifg.getId());
                ApiUtil.updateOrderTraceConfig("pre",sourceConfig);
            }
        }

    }

    public static void checkAndAdd(){
        String partnerCode ="YJP-TRD";
        List<OrderTraceConfigDTO> traceConfigQuery = findByPageTraceConfigQuery("test", partnerCode);
        for (OrderTraceConfigDTO orderTraceConfigDTO : traceConfigQuery) {
            addTrace("pre",orderTraceConfigDTO);
        }

    }



    public static List<OrderTraceConfigDTO> findByPageTraceConfigQuery(String code, String partnerCode) {
        OrderTraceConfigQueryParam queryParam =new OrderTraceConfigQueryParam();
        queryParam.setPartnerCode(partnerCode);
        queryParam.setPageIndex(1);
        queryParam.setPageSize(100);
        List<OrderTraceConfigDTO> traceConfigList = ApiUtil.findByPageTraceConfigQuery(code, queryParam);
        return traceConfigList;
    }


    public static void addTrace(String code, OrderTraceConfigDTO orderTraceConfigDTO) {
        ApiUtil.addOrderTraceConfig(code, orderTraceConfigDTO);
    }




}
