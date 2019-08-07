package com.ncu.appstore.controller;
import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * app-store-com.ncu.appstore.controller
 * created by LI LICHUNYAN at 2019/8/6
 */
@Controller
public class LoginController extends BaseController {
    @Autowired
    private DevUserService devUserService;
    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "devemail",required = true) String devemail,
                        @RequestParam(value = "devpassword", required=true) String devpassword)
    {
        DevUser devUser = devUserService.findDevUserByEmail(devemail);
        if(devUser==null||devUser.getDevpassword().equals(devpassword)==false){
            model.addAttribute("validationMessage","邮箱不存在或密码错误");
            return "login";
        }
        getSession().setAttribute("devUser",devUser);
        model.addAttribute("devUser",devUser);
        return "index";
    }

}
