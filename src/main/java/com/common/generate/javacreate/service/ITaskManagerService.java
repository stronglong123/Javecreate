package com.common.generate.javacreate.service;

import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.TaskManagerQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;

import java.util.List;

/**
 * @author xialei
 * @date  2020-10-30
 */
public interface ITaskManagerService {

     TaskManagerDTO detail(Long id);

     PageList<TaskManagerDTO> pageList(TaskManagerQueryDTO taskManager);

     void insert(TaskManagerDTO taskManager);

     void update(TaskManagerDTO taskManager);

     void delete(TaskManagerDTO taskManager);

}
