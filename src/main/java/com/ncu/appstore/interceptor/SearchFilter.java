package com.ncu.appstore.interceptor;

import com.ncu.appstore.common.PageHelper;
import com.ncu.appstore.dao.AppInfoMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * app-store-com.ncu.appstore.interceptor
 * created by LI LICHUNYAN at 2019/8/12
 */
public class SearchFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        HashMap<String,String> map = new HashMap<String,String>();
        String softwarename = request.getParameter("softwarename");
        String floatformid = request.getParameter("floatformid");
        String categorylevel1 = request.getParameter("categorylevel1");
        String categorylevel2 = request.getParameter("categorylevel2");
        String categorylevel3 = request.getParameter("categorylevel3");
        Integer pageNum = null;
        if(request.getParameter("pageNum")!=null){
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        map.put("softwarename",softwarename);
        map.put("floatformid",floatformid);
        map.put("categorylevel1",categorylevel1);
        map.put("categorylevel2",categorylevel2);
        map.put("categorylevel3",categorylevel3);
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        AppInfoMapper appInfoMapper = ctx.getBean(AppInfoMapper.class);
        PageHelper.startPage(pageNum, 10);//开始分页
        appInfoMapper.search(map);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        request.setAttribute("page", endPage );
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
