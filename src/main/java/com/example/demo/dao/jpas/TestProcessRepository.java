package com.example.demo.dao.jpas;

import com.example.demo.dao.entities.TestProcess;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName: TestProcessRepository
 * @Author: oldguy
 * @Description: TODO
 * @Time: 2019/4/1 0001 - 11:47
 * @Version: 1.0
 **/
public interface TestProcessRepository extends JpaRepository<TestProcess, Long> {
}
