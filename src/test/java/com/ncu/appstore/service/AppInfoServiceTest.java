package com.ncu.appstore.service;

import com.ncu.appstore.BaseTestClass;
import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;
import org.junit.Before;
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
 * @create: 2019-08-08 10:26
 **/
public class AppInfoServiceTest extends BaseTestClass {

    @Autowired
    private AppInfoService appInfoService;

    @Test
    public void testPage(){
        PageInfo<AppInfoDTO> page = appInfoService.page(1, 0, 5, new AppInfo());
        List<AppInfoDTO> data = page.getData();
        for (AppInfoDTO appInfo : data) {
            System.out.println(appInfo);
        }
    }
}