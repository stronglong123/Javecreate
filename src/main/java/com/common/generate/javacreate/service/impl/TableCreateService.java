package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.TableCreateBL;
import com.common.generate.javacreate.model.TableDTO;
import com.common.generate.javacreate.service.ITableCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date 2020/5/15 15:57
 */
@Service
public class TableCreateService implements ITableCreateService {
    @Autowired
    private TableCreateBL tableCreateBL;

    @Override
    public List<String> createTableInfo(List<TableDTO> tableDTOS) {
        List<String> tableInfo = tableCreateBL.createTableInfo(tableDTOS);
        return tableInfo;
    }
}
