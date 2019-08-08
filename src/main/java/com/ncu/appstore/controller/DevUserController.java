package com.ncu.appstore.controller;

import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * app-store-com.ncu.appstore.controller
 * created by LI LICHUNYAN at 2019/8/8
 */
@Controller
public class DevUserController extends BaseController{
    @Autowired
    private DevUserService devUserService;
    @RequestMapping("alterDevUserInfo")
    @ResponseBody
    public Map<String,Object> alterDevUserInfo(@RequestParam(value = "devcode") String devcode,
                                               @RequestParam(value = "devemail") String devemail,
                                               @RequestParam(value = "devpassword") String devpassword,
                                               @RequestParam(value = "devinfo") String devinfo,
                                               @RequestParam(value = "devname") String devname)
    {
        Map<String ,Object> resultMap = new HashMap<String ,Object>();
        DevUser devUser = (DevUser)getSession().getAttribute("devUser");
        if(devpassword!=null&&devpassword.equals("")==false){
            devUser.setDevpassword(devpassword);
        }
        if(devname!=null&&devname.equals("")==false){
            devUser.setDevname(devname);
        }
        if(devemail!=null&&devemail.equals("")==false){
            devUser.setDevemail(devemail);
        }
        if(devinfo!=null&&devinfo.equals("")==false){
            devUser.setDevinfo(devinfo);
        }
        if(devcode!=null&&devcode.equals("")==false){
            devUser.setDevcode(devcode);
        }
        if(devUserService.updateDevUser(devUser)>0){
            resultMap.put("message","ok");
        }else{
            resultMap.put("message","fail");
        }
        return resultMap;
    }
}
