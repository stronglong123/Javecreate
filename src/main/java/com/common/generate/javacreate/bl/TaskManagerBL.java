package com.common.generate.javacreate.bl;

import com.common.generate.javacreate.dao.TaskManagerMapper;
import com.common.generate.javacreate.enums.TaskStateEnum;
import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.TaskManagerQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.utils.NoGeneratorUtil;
import com.common.generate.javacreate.utils.UUIDUtil;
import com.common.generate.javacreate.utils.UserInfoUtils;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(TaskManagerBL.class);
    @Autowired
    private UserInfoUtils userInfoUtils;
    @Autowired
    private TaskManagerMapper taskManagerMapper;

    public TaskManagerDTO detail(Long id) {
        return taskManagerMapper.detail(id);
    }

    public PageList<TaskManagerDTO> pageList(TaskManagerQueryDTO taskManager) {
        PageHelper.startPage(taskManager.getPageNum(), taskManager.getPageSize());
//        taskManager.setCreateUser(userInfoUtils.getUser().getId().toString());
        List<TaskManagerDTO> list = taskManagerMapper.list(taskManager);
        return new PageList<>(list);
    }

    public void insert(TaskManagerDTO taskManager) {
        Integer userId = userInfoUtils.getUser().getId();
        taskManager.setId(UUIDUtil.getUuid());
        taskManager.setTaskNo(NoGeneratorUtil.createNO("TK"));
        taskManager.setState(TaskStateEnum.WAIT.getValue());
        taskManager.setCreateUser(userId.toString());
        taskManager.setLastUpdateUser(userId.toString());
        if (taskManager.getPriority() == null) {
            taskManager.setPriority(1);
        }
        taskManagerMapper.insert(taskManager);
    }


    public void update(TaskManagerDTO taskManager) {
        Integer userId = userInfoUtils.getUser().getId();
        taskManager.setLastUpdateUser(userId.toString());
        taskManagerMapper.update(taskManager);
    }

    public void delete(TaskManagerDTO taskManager) {
        taskManagerMapper.delete(taskManager);
    }

}
