package com.ncu.appstore.interceptor;

import com.ncu.appstore.controller.BaseController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: app-store
 * @description: 权限拦截器
 * @author: Leo
 * @create: 2019-08-11 22:15
 **/
public class PermissionInterceptor implements HandlerInterceptor {
    private Object devUser;
    private Object backendUser;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        devUser = BaseController.getSession().getAttribute("devUser");
        backendUser = BaseController.getSession().getAttribute("backendUser");
        //访问任意页面，用户登录信息已过期
        if (devUser == null && backendUser == null){
            response.sendRedirect(request.getContextPath()+"/index");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //访问后台页面
        if (modelAndView != null && modelAndView.getViewName() != null && modelAndView.getViewName().contains("backend")){
            //如果是前台用户
            if (devUser != null){
                response.sendRedirect(request.getContextPath()+"/index");
            }
            //后台用户，但已过期
            if (backendUser == null){
                response.sendRedirect(request.getContextPath()+"/index");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}