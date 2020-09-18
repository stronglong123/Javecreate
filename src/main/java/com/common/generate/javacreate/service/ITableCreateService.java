package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.TableDTO;

import java.util.List;

/**
 * @author xialei
 * @date 2020/5/15 15:57
 */
public interface ITableCreateService {

    List<String> createTableInfo(List<TableDTO> tableDTOS);

}
