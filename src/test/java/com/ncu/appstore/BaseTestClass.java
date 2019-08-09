package com.ncu.appstore;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 17:17
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-context-mybatis.xml",
        "classpath:spring-context-druid.xml"})
@WebAppConfiguration("src/main/resources")
public class BaseTestClass {

}