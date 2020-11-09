package com.common.generate.javacreate.controller;

import com.alibaba.fastjson.JSON;
import com.common.generate.javacreate.model.TaskManagerDTO;
import com.common.generate.javacreate.model.TaskManagerQueryDTO;
import com.common.generate.javacreate.model.base.search.PageList;
import com.common.generate.javacreate.service.ITaskManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xialei
 * @date 2020-10-30
 */
@RestController
public class TaskManagerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerController.class);

    @Autowired
    private ITaskManagerService taskManagerService;


    @PostMapping("/taskManager/pageList")
    public PageList<TaskManagerDTO> pageList(@RequestBody TaskManagerQueryDTO taskManager) {
        LOGGER.info("列表查询参数：{}", JSON.toJSONString(taskManager));
        return taskManagerService.pageList(taskManager);
    }


    @GetMapping("/taskManager/detail")
    public Object detail(@RequestParam Long id) {
        TaskManagerDTO taskManager = taskManagerService.detail(id);
        return taskManager;
    }

    @PostMapping("/taskManager/insert")
    public Boolean insert(@RequestBody TaskManagerDTO taskManager) {
        LOGGER.info("新增参数：{}", JSON.toJSONString(taskManager));
        taskManagerService.insert(taskManager);
        return true;
    }

    @PostMapping("/taskManager/update")
    public Boolean update(@RequestBody TaskManagerDTO taskManager) {
        LOGGER.info("修改：{}", JSON.toJSONString(taskManager));
        taskManagerService.update(taskManager);
        return true;
    }

    @PostMapping("/taskManager/delete")
    public Boolean delete(@RequestBody TaskManagerDTO taskManager) {
        LOGGER.info("删除：{}", JSON.toJSONString(taskManager));
        taskManagerService.delete(taskManager);
        return true;
    }

}
