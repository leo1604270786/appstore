package com.ncu.appstore.service;

import com.ncu.appstore.pojo.AppCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 15:08
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-mvc.xml","classpath:spring-context-mybatis.xml",
        "classpath:spring-context-druid.xml"})
@WebAppConfiguration("src/main/resources")
public class AppCategoryServiceTest {
    @Autowired
    private AppCategoryService appCategoryService;

    @Test
    public void testGetCategory(){
        String level = "level1";
        List<AppCategory> categoryByCategoryCode = appCategoryService.getCategoryByCategoryCode(level);
        for (AppCategory appCategory : categoryByCategoryCode) {
            System.out.println(appCategory.getCategoryname());
        }
    }
}