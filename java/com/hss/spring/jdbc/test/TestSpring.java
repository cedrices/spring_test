package com.hss.spring.jdbc.test;


import com.hss.spring.jdbc.service.MyHaosService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class TestSpring {

    @Resource
    private MyHaosService myHaosService;


    @Test
    public void testNewBean(){
        myHaosService.doSomething();
    }

}
