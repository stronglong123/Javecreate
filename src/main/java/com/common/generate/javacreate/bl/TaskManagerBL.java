package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.dao.TaskManagerMapper;
import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.base.PageResult;
import com.common.generate.javacreate.model.base.search.PageList;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xialei
 * @date 2020-10-30
 */
@Service
public class TaskManagerBL {
    @Autowired
    private TaskManagerMapper taskManagerMapper;

    public TaskManagerDTO detail(Long id) {
        return taskManagerMapper.detail(id);
    }

    public PageList<TaskManagerDTO> pageList(TaskManagerDTO taskManager) {
        PageHelper.startPage(taskManager.getPageNum(), taskManager.getPageSize());
        PageResult<TaskManagerDTO> pageResult = taskManagerMapper.pageList(taskManager);
        return pageResult.toPageList();
    }

    @Transactional
    public void insert(TaskManagerDTO taskManager) {
        taskManagerMapper.insert(taskManager);
    }

    @Transactional
    public void insertBatch(List<TaskManagerDTO> taskManagers) {
        taskManagerMapper.insertBatch(taskManagers);
    }

    @Transactional
    public void update(TaskManagerDTO taskManager) {
        taskManagerMapper.update(taskManager);
    }

    @Transactional
    public void delete(TaskManagerDTO taskManager) {
        taskManagerMapper.delete(taskManager);
    }

}
