package com.ncu.appstore.interceptor;


import com.ncu.appstore.common.PageHelper;
import com.ncu.appstore.dao.AppInfoMapper;
import com.ncu.appstore.pojo.AppInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * Create by CZM on 2019/8/9
 */
public class APPInfoPageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        AppInfoMapper appInfoMapper = ctx.getBean(AppInfoMapper.class);
        Integer pageNum = null;
        if(request.getParameter("pageNum")!=null){
           pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        PageHelper.startPage(pageNum, 5);//开始分页
        appInfoMapper.findAllToCheck();
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        request.setAttribute("page", endPage );
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
