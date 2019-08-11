package com.ncu.appstore.controller;

import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.service.AppVersionService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-11 18:58
 **/
@Controller
public class DownloadController extends BaseController {
    @Autowired
    private AppVersionService appVersionService;

    private static final String APK_UPLOAD_PATH = "/static/upload/apk/";

    @RequestMapping(value = "download")
    public ResponseEntity<byte[]> download(Long versionId) throws IOException {
        AppVersion version = appVersionService.getAppVersionById(versionId);
        //获取下载链接
        String downloadlink = version.getDownloadlink();
        String realPath = getRequest().getServletContext().getRealPath(APK_UPLOAD_PATH);
//        String link = downloadlink.replaceAll("/","\\\\\\\\");
        HttpHeaders httpHeaders = new HttpHeaders();
        File file = new File(realPath+downloadlink);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", version.getApkfilename());
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
    }
}