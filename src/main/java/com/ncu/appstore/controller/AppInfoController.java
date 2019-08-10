package com.ncu.appstore.controller;

import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.pojo.DataDictionary;
import com.ncu.appstore.service.AppCategoryService;
import com.ncu.appstore.service.AppInfoService;
import com.ncu.appstore.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;

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
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(AppInfo appInfo){
        //数据校验

        BaseResult baseResult = appInfoService.save(appInfo);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //attr.addFlashAttribute("baseResult",baseResult);
            return "redirect:/app/list";
        }
        //保存失败
        else {
            //model.addAttribute("baseResult",baseResult);
            return "/developer/app_form";
        }
    }

    /**
     * 分页查新app信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<AppInfoDTO> page(HttpServletRequest request, AppInfo appInfo){
        //DataTables参数
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");
        int intDraw = draw == null ? 0 : Integer.parseInt(draw);
        int intStart = start == null ? 0 : Integer.parseInt(start);
        int intLength = length == null ? 10 : Integer.parseInt(length);
        //封装 DataTables 需要的数据
        return appInfoService.page(intDraw, intStart, intLength, appInfo);
    }

    /**
     * 获取分类列表
     * @param level 分类等级
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "category", method = RequestMethod.GET)
    public List<AppCategory> getCategory(String level, String parent){
        if (parent != null && parent.length() > 0){
            return appCategoryService.getCategoryByCategoryCodeAndParent(level,parent);
        }
        return appCategoryService.getCategoryByCategoryCode(level);
    }

    /**
     * 获取app状态
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "status", method = RequestMethod.GET)
    public List<DataDictionary> getStatus(){
        return dataDictionaryService.getDataDictionaryByTypeCode("status");
    }

    /**
     * 获取app平台
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "floar", method = RequestMethod.GET)
    public List<DataDictionary> getFloar(){
        return dataDictionaryService.getDataDictionaryByTypeCode("floar");
    }


}