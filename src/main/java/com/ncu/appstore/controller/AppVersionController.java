package com.ncu.appstore.controller;

import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.service.AppInfoService;
import com.ncu.appstore.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-11 15:28
 **/
@Controller
@RequestMapping("appversion")
public class AppVersionController extends BaseController {
    @Autowired
    private AppVersionService appVersionService;
    @Autowired
    private AppInfoService appInfoService;

    private static final String APK_UPLOAD_PATH = "/static/upload/apk/";

    @ModelAttribute
    public AppVersion getAppVersionById(Long id, Long appId){
        AppVersion appVersion = null;
        if (id == null){
            appVersion = new AppVersion();
            appVersion.setAppid(appId);
        } else {
            appVersion = appVersionService.getAppVersionById(id);
        }
        return appVersion;
    }
    @RequestMapping(value = "form")
    public String form(){
        return "developer/appversion_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(AppVersion appVersion, Model model, RedirectAttributes attr,@RequestParam("apkfile") CommonsMultipartFile apkfile){
        //数据校验

        //保存文件
        String path = saveFile(apkfile);
        appVersion.setApklocpath(path);
        appVersion.setDownloadlink(apkfile.getOriginalFilename());
        BaseResult baseResult = appVersionService.save(appVersion);
        //保存成功
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS){
            //修改当前app的最新版本号
            appInfoService.updateVersion(appVersion.getId(),appVersion.getAppid());
            //重定向到列表页，并返回成功提示
            attr.addFlashAttribute("baseResult",baseResult);
            return "redirect:/app/list";
        }
        //保存失败
        else {
            //转发到表单页，并提示保存失败
            model.addAttribute("baseResult",baseResult);
            return "/developer/appversion_form";
        }
    }

    /**
     * 保存apk文件
     * @param apkFile
     * @return
     */
    private String saveFile(MultipartFile apkFile){
        //文件名
        String fileName = apkFile.getOriginalFilename();
        //后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        if (!".apk".equals(fileSuffix)){
            throw new RuntimeException("上传的文件不是apk格式");
        }
        //文件上传路径
        String filePath = getSession().getServletContext().getRealPath(APK_UPLOAD_PATH);
        //判断路径是否存在
        File file = new File(filePath);
        //不存在 则创建
        if (!file.exists()){
            file.mkdir();
        }
        file = new File(filePath, fileName);
        try {
            apkFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpServletRequest request = getRequest();
        //服务端路径
        String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        return serverPath + APK_UPLOAD_PATH + fileName;
    }
}