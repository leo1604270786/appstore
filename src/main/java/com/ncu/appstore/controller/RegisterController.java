package com.ncu.appstore.controller;

import com.ncu.appstore.common.CodeCaptchaServlet;
import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * app-store-com.ncu.appstore.controller
 * created by LI LICHUNYAN at 2019/8/6
 */
@Controller
public class RegisterController extends BaseController {
    @Autowired
    private DevUserService devUserService;
    @RequestMapping("/checkDevCode")//判断用户名是否已被注册
    @ResponseBody
    public Map<String, Object> checkDevCode(@RequestParam(value = "devcode", required = true) String devcode) {
        Map map = new HashMap<String, Object>();
        DevUser devUser = devUserService.findDevUserByCode(devcode);
        if (devUser == null) {
            //未注册
            map.put("message", "success");
        } else {
            //已注册
            map.put("message", "该用户名已被使用");
        }
        return map;
    }
    @RequestMapping("/checkDevEmail")//判断用户名是否已被注册
    @ResponseBody
    public Map<String, Object> checkDevEmail(@RequestParam(value = "devemail", required = true) String devemail) {
        Map map = new HashMap<String, Object>();
        DevUser devUser = devUserService.findDevUserByEmail(devemail);
        if (devUser == null) {
            //未注册
            map.put("message", "success");
        } else {
            //已注册
            map.put("message", "该邮箱已被注册");
        }
        return map;
    }
    /**
     * 判断验证码是否正确
     *
     * @param code
     * @return
     */
    @RequestMapping("/checkCode")
    @ResponseBody
    public Map<String, Object> checkCode( @RequestParam(value = "code", required = false) String code) {

        Map map = new HashMap<String, Object>();
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String vcode = (String) attrs.getRequest().getSession().getAttribute(CodeCaptchaServlet.VERCODE_KEY);

        if (code.equals(vcode)) {
            //验证码正确
            map.put("message", "success");
        } else {
            //验证码错误
            map.put("message", "fail");
        }
        return map;
    }
    @RequestMapping("/register")
    public String register(Model model, @RequestParam(value = "devcode" ,required = true) String devcode,
                           @RequestParam(value = "devname" ,required = true) String devname,
                           @RequestParam(value = "devemail" ,required = true) String devemail,
                           @RequestParam(value = "devpassword" ,required = true) String devpassword)
    {
        DevUser devUser = new DevUser();
        devUser.setDevcode(devcode);
        devUser.setDevemail(devemail);
        devUser.setDevname(devname);
        devUser.setDevpassword(devpassword);
        devUser.setCreationdate(new java.util.Date());
        devUserService.addDevUser(devUser);
        model.addAttribute("registerMessage","注册成功");
        return "register/registerSuccess";
    }
}
