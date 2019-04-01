package com.example.demo.controllers;

import com.example.demo.dao.entities.TestProcess;
import com.example.demo.dao.jpas.TestProcessRepository;
import com.example.demo.services.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @ClassName: TestProcessController
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 11:48
 * @Version: 1.0
 **/
@RequestMapping("TestProcess")
@RestController
public class TestProcessController {

    @Autowired
    private TestProcessRepository testProcessRepository;
    @Autowired
    private FlowService flowService;

    @PostMapping("newInstance")
    public Object newInstance() {

        // 持久化流程实例
        TestProcess testProcess = new TestProcess();
        testProcess.setCreateTime(new Date());
        testProcess.setName("测试流程:" + System.currentTimeMillis());
        testProcess.setAuditStatus(2);
        testProcess.setStatus(1);
        testProcessRepository.save(testProcess);

        // 开启流程实例
        flowService.openProcessInstance(TestProcess.class.getSimpleName(), "123", testProcess.getId());

        return "success";
    }

}
