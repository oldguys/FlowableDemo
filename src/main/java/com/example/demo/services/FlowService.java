package com.example.demo.services;

import com.example.demo.dto.TaskWebResult;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.identitylink.api.IdentityLink;
import org.flowable.identitylink.api.IdentityLinkInfo;
import org.flowable.task.api.Task;
import org.flowable.task.api.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: FlowService
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 11:48
 * @Version: 1.0
 **/
@Service
public class FlowService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     *  获取当前任务列表
     * @return
     */
    public List<TaskWebResult> getCurrentTaskList() {
        List<Task> taskList = taskService.createTaskQuery().list();

        List<TaskWebResult> taskWebResults = transFromTasks(taskList);
        return taskWebResults;
    }

    /**
     *  将任务接口转换为对象
     * @param taskList
     * @return
     */
    private List<TaskWebResult> transFromTasks(List<Task> taskList) {

        List<TaskWebResult> results = new ArrayList<>(taskList.size());
        taskList.forEach(obj -> {
            TaskWebResult result = new TaskWebResult();
            result.setAssignee(obj.getAssignee());
            result.setTaskName(obj.getName());
            result.setTaskId(obj.getId());
            result.setProcessInstanceId(obj.getProcessInstanceId());

            // 获取 组任务-任务执行人
            List<IdentityLink> identityLinks = taskService.getIdentityLinksForTask(obj.getId());
            if (!identityLinks.isEmpty()) {
                List<String> candidates = new ArrayList<>();
                identityLinks.forEach(candidateUser -> {
                    candidates.add(candidateUser.getUserId());
                });
                result.setCandidatesUser(candidates);
            }

            results.add(result);
        });
        return results;
    }


    /**
     * 开启流程
     *
     * @param processDefinitionKey
     * @param assignee
     * @param id
     */
    public void openProcessInstance(String processDefinitionKey, String assignee, Long id) {

        Map<String, Object> variables = new HashMap<>(1);
        variables.put("assignee", assignee);

        String businessKey = processDefinitionKey + "." + id;

        runtimeService.startProcessInstanceByKey(processDefinitionKey, businessKey, variables);
    }
}
