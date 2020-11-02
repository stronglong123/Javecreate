package com.common.generate.javacreate.dao;

import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.base.PageResult;


import java.util.List;

/**
 * @author xialei
 * @date  2020-10-30
 */
public interface TaskManagerMapper {

     TaskManagerDTO detail(Long id);

     PageResult<TaskManagerDTO> pageList(TaskManagerDTO taskManager);

     int insert(TaskManagerDTO taskManager);

     int insertBatch(List<TaskManagerDTO> taskManagers);

     int update(TaskManagerDTO taskManager);

     int delete(TaskManagerDTO taskManager);

}