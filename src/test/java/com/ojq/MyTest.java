package com.ojq;

import com.ojq.config.ProjectConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Version 1.0
 * @Author Jin_quan Ou
 * @Date 2023-03-28 14:45
 */
@SpringBootTest
public class MyTest {

    @Test
    public void test(){
        System.out.println(ProjectConfig.getProfile());
    }

}
