package com.example.demo.controllers;

import com.example.demo.services.FlowService;
import org.flowable.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TaskController
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 12:35
 * @Version: 1.0
 **/
@RequestMapping("task")
@RestController
public class TaskController {

    @Autowired
    private FlowService flowService;
    @Autowired
    private TaskService taskService;

    /**
     *  完成任务
     * @param taskId
     * @return
     */
    @PostMapping("complete/{taskId}")
    public Object completeTask(@PathVariable("taskId") String taskId) {
        taskService.complete(taskId);
        return "success";
    }

    /**
     *  获取当前任务列表
     * @return
     */
    @GetMapping("current")
    public Object getCurrentTaskList() {
        return flowService.getCurrentTaskList();
    }
}
