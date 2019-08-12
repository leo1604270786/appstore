package com.ncu.appstore.controller;

import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.pojo.DataDictionary;
import com.ncu.appstore.service.AppCategoryService;
import com.ncu.appstore.service.AppInfoService;
import com.ncu.appstore.service.AppVersionService;
import com.ncu.appstore.service.DataDictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
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
@RequestMapping("app")
public class AppInfoController extends BaseController {
    @Autowired
    private AppInfoService appInfoService;
    @Autowired
    private AppCategoryService appCategoryService;
    @Autowired
    private DataDictionaryService dataDictionaryService;
    @Autowired
    private AppVersionService appVersionService;

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
    public String save(@Valid AppInfo appInfo, Model model, RedirectAttributes attr, BindingResult bindingResult){
        //数据校验
        if (bindingResult.hasErrors()){
            //拼接错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : allErrors) {
                errorMsg.append(error.getDefaultMessage()).append("<br/>");
            }
            //转发到表单页，并提示保存失败
            model.addAttribute("baseResult",BaseResult.fail(errorMsg.toString()));
            return "/developer/app_form";
        }
        BaseResult baseResult = appInfoService.save(appInfo);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //重定向到列表页，并返回成功提示
            attr.addFlashAttribute("baseResult",baseResult);
            return "redirect:/app/list";
        }
        //保存失败
        else {
            //转发到表单页，并提示保存失败
            model.addAttribute("baseResult",baseResult);
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
        int intLength = length == null ? 5 : Integer.parseInt(length);
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

    /**
     * 检查apk名称是否重复
     * @param apkname
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "checkApkName", method = RequestMethod.GET)
    public Map<String,String> checkApkName(String apkname){
        Map<String,String> result = new HashMap<>();
        int count = appInfoService.countAppInfoByApkName(apkname);
        if (count <= 0){
            result.put("has","false");
        } else {
            result.put("has","true");
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public String delete(Long id, Model model){
        BaseResult baseResult = null;
        //先删除该app下的所有版本
        int i = appVersionService.deleteByAppId(id);
        //删除app基础信息
        baseResult = appInfoService.delete(id);
        //失败
        if (i <= 0 || baseResult.getStatus() == BaseResult.STATUS_FAIL){
            baseResult = BaseResult.fail("删除失败");
        }
        model.addAttribute("baseResult",baseResult);
        return "developer/app_list";
    }

    @RequestMapping(value = "info",method = RequestMethod.GET)
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
        return "developer/app_info";
    }

    /**
     * 上架
     * @param id
     * @return
     */
    @RequestMapping(value = "onsale",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> onsale(Long id){
        //已上架：7
        int i = appInfoService.onSale(7L, id,new Date());
        Map<String,String> result = new HashMap<>();
        if (i <= 0){
            result.put("status","fail");
        } else {
            result.put("status","success");
        }
        return result;
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @RequestMapping(value = "offsale",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> offsale(Long id){
        //已下架：8
        int i = appInfoService.offSale(8L, id, new Date());
        Map<String,String> result = new HashMap<>();
        if (i <= 0){
            result.put("status","fail");
        } else {
            result.put("status","success");
        }
        return result;
    }
}