package com.ncu.appstore.controller;


import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.service.AppCategoryService;
import com.ncu.appstore.service.AppInfoService;
import com.ncu.appstore.service.AppVersionService;
import com.ncu.appstore.service.DataDictionaryService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 11:06
 **/
@Controller
public class CheckAPPController extends BaseController {
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private AppVersionService appVersionService;

    /**
     * 跳转到列表页
     * @return
     */
    @RequestMapping(value = "/check_app/list",method = RequestMethod.GET)
    public String list(){
        return "/backend/app_list";
    }
    @RequestMapping("/check_app/search")
    public String search()
    {
       return "/backend/app_list";
    }
    @RequestMapping("/check_app/check/{id}")
    public String check(@PathVariable("id") Long id)
    {
        return "redirect:/check_app/info?id="+id;
    }
    @RequestMapping("/check_app/pass")
    @ResponseBody
    public Map<String,Object> pass(@RequestParam("appInfoId") long id){
        Map<String,Object> map = new HashMap<String,Object>();
        if(appInfoService.pass(id)>0){
            map.put("message","success");
        }else {
            map.put("message","fail");
        }
        return map;
    }
    @RequestMapping("/check_app/reject")
    @ResponseBody
    public Map<String,Object> reject(@RequestParam("appInfoId") long id){
        Map<String,Object> map = new HashMap<String,Object>();
        if(appInfoService.reject(id)>0){
            map.put("message","success");
        }else {
            map.put("message","fail");
        }
        return map;
    }
    @RequestMapping(value = "/check_app/info",method = RequestMethod.GET)
    public String info(Long id, Model model){
        //查询app基础信息
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        AppInfoDTO appInfoDTO = new AppInfoDTO();
        BeanUtils.copyProperties(appInfo,appInfoDTO);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appInfo.getCategorylevel1().getCategoryname()).append("->");
        stringBuilder.append(appInfo.getCategorylevel2().getCategoryname()).append("->");
        stringBuilder.append(appInfo.getCategorylevel3().getCategoryname());
        AppCategory appCategory = new AppCategory();
        appCategory.setCategoryname(stringBuilder.toString());
        appInfoDTO.setCategorylevel(appCategory);
        //查询该app版本信息
        List<AppVersion> appVersions = appVersionService.selectByAppId(id + "");
        //放入model
        model.addAttribute("appInfo",appInfoDTO);
        model.addAttribute("versionList",appVersions);
        return "backend/app_info";
    }

}