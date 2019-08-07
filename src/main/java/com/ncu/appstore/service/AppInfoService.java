package com.ncu.appstore.service;

import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 14:03
 **/
public interface AppInfoService {
    /**
     * 分页查询
     * @param draw
     * @param start 开始记录
     * @param length 每页大小
     * @param appInfo 封装查询条件
     * @return
     */
    PageInfo<AppInfo> page(int draw, int start, int length, AppInfo appInfo);
}