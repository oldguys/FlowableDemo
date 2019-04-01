package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: MyService
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 11:38
 * @Version: 1.0
 **/
@Service
public class MyService {

    public Set<String> test(String formKey) {
        System.out.println(getClass().getName() + ":" + System.currentTimeMillis());

        Set<String> candidateUsers = new HashSet<>();
        candidateUsers.add("123");
        candidateUsers.add("456");
        candidateUsers.add("789");

        return candidateUsers;
    }
}
