package com.ncu.appstore.service.impl;

import com.ncu.appstore.controller.BaseController;
import com.ncu.appstore.dao.AppVersionMapper;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-11 14:36
 **/
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public List<AppVersion> selectByAppId(String appId) {
        return appVersionMapper.selectByAppId(appId);
    }

    @Override
    public AppVersion getAppVersionById(Long id) {
        return appVersionMapper.getAppVersionById(id+"");
    }

    @Override
    public BaseResult save(AppVersion appVersion) {
        DevUser devUser = (DevUser) BaseController.getSession().getAttribute("devUser");
        //新增
        if (appVersion.getId() == null || "".equals(appVersion.getId().toString())){
            appVersion.setCreateby(devUser.getId());
            appVersion.setCreationdate(new Date());
            appVersion.setModifyby(devUser.getId());
            appVersion.setModifydate(new Date());
            appVersionMapper.insert(appVersion);
        }
        //编辑
        else{
            appVersion.setModifydate(new Date());
            appVersion.setModifyby(devUser.getId());
            appVersionMapper.update(appVersion);
        }
        return BaseResult.success("保存App版本信息成功");
    }
}