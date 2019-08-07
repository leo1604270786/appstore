package com.ncu.appstore.service.impl;

import com.ncu.appstore.dao.AppInfoMapper;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 14:06
 **/
@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    public PageInfo<AppInfo> page(int draw, int start, int length, AppInfo appInfo) {
        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        int count = appInfoMapper.selectCount(appInfo);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setError("");
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",appInfo);

        pageInfo.setData(appInfoMapper.page(params));
        return pageInfo;
    }
}