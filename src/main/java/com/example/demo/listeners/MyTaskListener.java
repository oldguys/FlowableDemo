package com.example.demo.listeners;

import com.example.demo.services.MyService;
import com.example.demo.utils.SpringContextUtils;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

import java.util.Set;

/**
 * @ClassName: MyTaskListener
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 11:36
 * @Version: 1.0
 **/
public class MyTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("进入任务");
        System.out.println("任务名称:" + delegateTask.getName());

        //调用Spring容器类
        MyService myService = SpringContextUtils.getBean(MyService.class);
        Set<String> candidateUsers =  myService.test(delegateTask.getFormKey());
        // 注入审批组员
        delegateTask.addCandidateUsers(candidateUsers);
    }
}
