package com.example.demo.dto;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName: TaskWebResult
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 12:48
 * @Version: 1.0
 **/
public class TaskWebResult {

    private String taskId;

    private String assignee;

    private List<String> candidatesUser = Collections.emptyList();

    private String taskName;

    private String processInstanceId;


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public List<String> getCandidatesUser() {
        return candidatesUser;
    }

    public void setCandidatesUser(List<String> candidatesUser) {
        this.candidatesUser = candidatesUser;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}
