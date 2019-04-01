package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/25 0025.
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl.buildProcessEngine(..))")
    public void annotationPoinCut(){}

    @After("annotationPoinCut()")
    public void test(){
        System.out.println();
        System.out.println("切割");
        System.out.println();
    }
}
