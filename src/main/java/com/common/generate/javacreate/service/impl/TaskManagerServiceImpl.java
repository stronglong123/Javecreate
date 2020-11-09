package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.bl.TaskManagerBL;
import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.TaskManagerQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.ITaskManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xialei
 * @date 2020-10-30
 */
@Service
public class TaskManagerServiceImpl implements ITaskManagerService {
    @Autowired
    private TaskManagerBL taskManagerBl;

    @Override
    public TaskManagerDTO detail(Long id) {
        return taskManagerBl.detail(id);
    }

    @Override
    public PageList<TaskManagerDTO> pageList(TaskManagerQueryDTO taskManager) {
        return taskManagerBl.pageList(taskManager);
    }

    @Override
    public void insert(TaskManagerDTO taskManager) {
        taskManagerBl.insert(taskManager);
    }

    @Override
    public void update(TaskManagerDTO taskManager) {
        taskManagerBl.update(taskManager);
    }

    @Override
    public void delete(TaskManagerDTO taskManager) {
        taskManagerBl.delete(taskManager);
    }

}
