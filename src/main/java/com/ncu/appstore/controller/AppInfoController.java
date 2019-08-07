package com.ncu.appstore.controller;

import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute
    private AppInfo getAppInfo(Long id){
        AppInfo appInfo = null;
        if (id != null){
            appInfo = appInfoService.getAppInfoById(id);
        }else{
            appInfo = new AppInfo();
        }
        return appInfo;
    }

    /**
     * 跳转到列表页
     * @return
     */
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(){
        return "/developer/app_list";
    }

    /**
     * 跳转到表单页
     * @return
     */
    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(){
        return "/developer/app_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(AppInfo appInfo, Model model, RedirectAttributes attr){
        //数据校验

        BaseResult baseResult = appInfoService.save(appInfo);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            attr.addFlashAttribute("baseResult",baseResult);
            return "redirect:/app/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult",baseResult);
            return "/developer/app_form";
        }
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