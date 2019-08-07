package com.ncu.appstore.service.impl;

import com.ncu.appstore.dao.AppInfoMapper;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-07 14:06
 **/
@Service
@Transactional(readOnly = true)
public class AppInfoServiceImpl implements AppInfoService {
    @Autowired
    private AppInfoMapper appInfoMapper;
    public PageInfo<AppInfo> page(int draw, int start, int length, AppInfo appInfo) {
        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",appInfo);
        List<AppInfo> appInfos = appInfoMapper.page(params);
        //由于可能有查询条件查询，所以须在查询后得到记录总数
        int count = appInfos.size();
        pageInfo.setData(appInfos);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setError("");
        return pageInfo;
    }

    @Override
    public AppInfo getAppInfoById(Long id) {
        return appInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false)
    public BaseResult save(AppInfo appInfo) {
        //新增
        if (appInfo.getId() == null || "".equals(appInfo.getId().toString())){
            appInfoMapper.insert(appInfo);
        }
        //编辑
        else{
            appInfoMapper.updateByPrimaryKeySelective(appInfo);
        }
        return BaseResult.success("保存App基础信息成功");
    }
}