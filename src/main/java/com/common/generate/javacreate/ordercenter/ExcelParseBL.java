package com.common.generate.javacreate.ordercenter;

import com.common.generate.javacreate.model.FileDTO;
import com.common.generate.javacreate.model.text.TextDTO;
import com.common.generate.javacreate.ordercenter.dto.FieldDTO;
import com.common.generate.javacreate.utils.ExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2022/11/17 11:14
 */

@Service
public class ExcelParseBL {

    public static void main(String[] args) throws Exception {
        parseFile();
//        List<FieldDTO> fieldDTOS = new ArrayList<>();
//        fieldDTOS.stream().map(it->it.getField()).collect(Collectors.joining(","));
//        List<String> list = Arrays.asList("1");
//        String join = StringUtils.join(list, ",");
//        System.out.println(join);
//
//
//        List<String> list2 = Collections.emptyList();
//        String join2 = StringUtils.join(list2, ",");
//        System.out.println(join2);
    }

    private static void parseFile() throws Exception {
        String filePath = "C:\\Users\\Administrator\\Desktop\\ehr.xlsx";
        List<FieldDTO> fieldDTOS = ExcelUtils.readExcelToEntity(FieldDTO.class, filePath, "ehr.xlsx");
        StringBuilder result = new StringBuilder();
        for (FieldDTO it : fieldDTOS) {
            String field = it.getField();
            if(StringUtils.isEmpty(field)){
                continue;
            }
            if(StringUtils.isNotEmpty(it.getRemark())){
                result.append("    /**\n*").append(it.getRemark()).append("\n").append("*/").append("\n");
            }
            result.append("private String ").append(field).append(";");
        }
        System.out.println(result);
    }


}
