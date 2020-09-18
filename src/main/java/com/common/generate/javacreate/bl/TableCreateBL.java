package com.common.generate.javacreate.bl;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.utils.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xialei
 * @date 2020/5/15 15:59
 */
@Service
public class TableCreateBL {
    private static final Logger logger = LoggerFactory.getLogger(TableCreateBL.class);

    public List<String> createTableInfo(List<TableDTO> tableDTOS) {
        List<String> result = new ArrayList<>();
        Map<String, List<TableDTO>> tableMap = tableDTOS.stream().collect(Collectors.groupingBy(TableDTO::getTableName));
        for (String tableName : tableMap.keySet()) {
            List<TableDTO> dtos = tableMap.get(tableName);
            if (CollectionUtils.isEmpty(dtos)) {
                continue;
            }
            result.add(convertTable2Info(dtos, tableName, dtos.get(0).getTableComment()));
        }
        logger.info("创建表结构：{}", JSON.toJSONString(result));
        return result;
    }


    private String convertTable2Info(List<TableDTO> dtos, String tableName, String tableComment) {
        String tableBody = setTableBody(dtos);
        return setTableFoot(tableBody, tableName, tableComment);
    }

    private String setTableBody(List<TableDTO> dtos) {
        StringBuilder tableBody = new StringBuilder();
        tableBody.append("`Id` BIGINT ( 20 ) NOT NULL COMMENT 'id',");
        for (TableDTO dto : dtos) {
            tableBody.append("`" + StringUtil.firstToUpperCase(dto.getColumnName()) + "`").
                    append(setType(dto.getType())).
                    append(setIsNull(dto.getIsNull(), dto.getDefaultValue())).
                    append(setComment(dto.getComment()));
        }
        tableBody.append(addDefaultColumn());
        return tableBody.toString();
    }

    private String setType(String type) {
        StringBuilder sb = new StringBuilder();
        switch (type) {
            case "BOOLEAN":
                sb.append("Boolean");
                break;
            case "TINYINT":
                sb.append("TINYINT (4)");
                break;
            case "INTEGER":
                sb.append("Integer (11)");
                break;
            case "BIGINT":
                sb.append("BIGINT (20)");
                break;
            case "DECIMAL":
                sb.append("decimal (18,6)");
                break;
            case "VARCHAR":
                sb.append("VARCHAR (50)");
                break;
            case "DATE":
                sb.append("datetime");
                break;
            default:
                sb.append("VARCHAR (50)");
        }
        return sb.toString();
    }

    private String setIsNull(String isNull, String defaultValue) {
        StringBuilder result = new StringBuilder();
        if ("FALSE".equals(isNull)) {
            result.append(" NOT NULL ");
            if (StringUtils.isNotEmpty(defaultValue)) {
                result.append(" DEFAULT '" + defaultValue + "' ");
            }
        } else {
            result.append(" DEFAULT NULL ");
        }
        return result.toString();
    }

    private String setComment(String comment) {
        if(StringUtils.isEmpty(comment)){
            return ",";
        }
        return "COMMENT '" + comment + "',";
    }

    private String addDefaultColumn() {
        StringBuilder tableBody = new StringBuilder();
//        tableBody.append("`Id` BIGINT ( 20 ) NOT NULL COMMENT 'id',");
        tableBody.append("`CreateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',");
        tableBody.append("`LastUpdateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',");
        tableBody.append("`CreateUser` VARCHAR ( 20 ) DEFAULT NULL COMMENT '创建人',");
        tableBody.append("`LastUpdateUser` VARCHAR ( 20 ) DEFAULT NULL COMMENT '修改人',");
        return tableBody.toString();
    }


    private String setTableFoot(String tableBodyBody, String tableName, String tableComment) {
        return "CREATE TABLE `" + tableName + "` (" +
                tableBodyBody + " PRIMARY KEY (`id`) USING BTREE ) COMMENT = '" + tableComment + "';";
    }


}
