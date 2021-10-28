package com.common.generate.javacreate.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.common.generate.javacreate.model.base.Result;
import com.common.generate.javacreate.model.base.exception.BusinessValidateException;
import com.common.generate.javacreate.test.transferNote.TransferNoteDTO;
import com.common.generate.javacreate.utils.HttpClientUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xialei
 * @date 2021/8/4 14:47
 */
public class CancelTransferNoteService {

    private static final String baseUrl = "http://wms.pre.yijiupi.com/supplyChain/";

    private static final String token ="c643db99-6729-491f-9fa3-848072a752de\n";

    public static void main(String[] args){
        CancelTransferNoteByNos();
    }

    public static void CancelTransferNoteByNos(){
        List<String> nos = getTransferNo();
        Integer orgId = 487;
        for (String no : nos) {
            TransferNoteDTO transferNoteDTO = getTransferNoteList(no);
            if (transferNoteDTO.getState() != (byte) 2) {
                System.out.println(no+"单据非待审核状态，无法取消");
            }
//            cancelTransferNote(no, transferNoteDTO.getOrgId());
        }
    }


    public static TransferNoteDTO getTransferNoteList(String businessNo) {
        String url = "/transfernote/getTransferNoteList";
        url = baseUrl + url;
        String body = "{\"pageNum\":1,\"pageSize\":20, \"transferNo\":\"" + businessNo + "\"}";
        String resultstr = HttpClientUtils.doPostWithToken(token, url, body);
        Result result = JSON.parseObject(resultstr, Result.class);
        Object data = result.getData();
        JSONObject pageList = (JSONObject) data;
        Object dataList = pageList.get("dataList");
        System.out.println(dataList);
        List<TransferNoteDTO> transferNoteDTOS = JSON.parseArray(JSON.toJSONString(dataList), TransferNoteDTO.class);
        if(CollectionUtils.isEmpty(transferNoteDTOS)){
            throw new BusinessValidateException(businessNo + "不存在");
        }
        return transferNoteDTOS.get(0);
    }

    public static void cancelTransferNote(String businessNo,Integer orgId) {
        String xc = businessNo.replace("XC", "");
        String url = "/erpAllotOrder/cancleErpAllotOrder/" + xc + "/" + orgId;
        url = baseUrl + url;
        String resultstr = HttpClientUtils.doGetWithToken(token, url);
        System.out.println(businessNo + ":" + resultstr);
    }



    private static List<String> getTransferNo(){
        return Arrays.asList("XC202107090072","XC202103300127","XC202103300125","XC202103300124","XC202103300123",
                "XC202103300109","XC202103300090","XC202103300006","XC202103190059","XC202103010007","XC202101260036");
    }


}
