package com.ncu.appstore.controller;
import com.ncu.appstore.pojo.BackendUser;
import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.BackendUserService;
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
    @Autowired
    private BackendUserService backendUserService;
    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "devemail",required = true) String devemail,
                        @RequestParam(value = "devpassword", required=true) String devpassword)
    {
        model.addAttribute("devemail",devemail);
        model.addAttribute("devpassword",devpassword);
        DevUser devUser = devUserService.findDevUserByEmail(devemail);
        if(devUser==null){
            model.addAttribute("error","email_fail");
            return "developer/login";
        }else if(devUser.getDevpassword().equals(devpassword)==false){
            model.addAttribute("error","pwd_fail");
            return "developer/login";
        }
        getSession().setAttribute("devUser",devUser);
        model.addAttribute("devUser",devUser);
        return "developer/index";
    }
    @RequestMapping("/login_backend")
    public String login_backend(Model model, @RequestParam(value = "usercode",required = true) String usercode,
                        @RequestParam(value = "userpassword", required=true) String userpassword)
    {
        model.addAttribute("usercode",usercode);
        model.addAttribute("userpassword",userpassword);
        BackendUser backendUser = backendUserService.findBackendUserByCode(usercode);
        if(backendUser==null){
            model.addAttribute("error","usercode_fail");
            return "backend/login";
        }else if(backendUser.getUserpassword().equals(userpassword)==false){
            model.addAttribute("error","pwd_fail");
            return "backend/login";
        }
        getSession().setAttribute("backendUser",backendUser);
        model.addAttribute("backendUser",backendUser);
        return "backend/index";
    }
    /**
     * 退出登录

     * @return
     */
    @RequestMapping("/logout")
    public String exit() {
        getSession().removeAttribute( "devUser" );
        getSession().invalidate();
        return "index";
    }
    /**
     * 退出登录

     * @return
     */
    @RequestMapping("/logout_backend")
    public String exit_backend( ) {
        getSession().removeAttribute( "backendUser" );
        getSession().invalidate();
        return "index";
    }
    @RequestMapping("DevUserDetail")
    public String devUserDetail(Model model){
        DevUser devUser = (DevUser)getSession().getAttribute("devUser");
        if(devUser==null){
            return "index";
        }else{
            model.addAttribute("devUser",devUser);
            return "developer/DevUserDetail";
        }
    }
}
