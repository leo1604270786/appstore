package com.ncu.appstore.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: my-shop
 * @description: 上传控制器
 * @author: Leo
 * @create: 2019-06-12 17:29
 **/
@Controller
@RequestMapping("app")
public class UploadController extends BaseController{

    private static final String UPLOAD_PATH = "/static/upload/";

    /**
     * 上传图片
     * @param dropFile
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        //前端上传的文件
        MultipartFile myFile = dropFile;
        //文件名
        String fileName = myFile.getOriginalFilename();
        //后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        //文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        //判断路径是否存在
        File file = new File(filePath);
        //不存在 则创建
        if (!file.exists()){
            file.mkdir();
        }
        //将文件更名后写入指定路径下
        file = new File(filePath, UUID.randomUUID() + "" + System.currentTimeMillis() + fileSuffix);
        try {
            myFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Dropzone上传
        //String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        result.put("fileName",UPLOAD_PATH + file.getName());
        return result;
    }
}