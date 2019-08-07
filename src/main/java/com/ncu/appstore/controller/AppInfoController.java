package com.ncu.appstore.controller;

import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 11:06
 **/
@Controller
@RequestMapping("app")
public class AppInfoController extends BaseController {
    @Autowired
    private AppInfoService appInfoService;
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "/developer/app_list";
    }

    /**
     * 分页查新app信息
     * @param draw
     * @param start 开始记录
     * @param length 每页长度
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<AppInfo> page(String draw, String start, String length, AppInfo appInfo){
        int intDraw = draw == null ? 0 : Integer.parseInt(draw);
        int intStart = start == null ? 0 : Integer.parseInt(start);
        int intLength = length == null ? 10 : Integer.parseInt(length);
        //封装 DataTables 需要的数据
        return appInfoService.page(intDraw,intStart,intLength,appInfo);
    }
}