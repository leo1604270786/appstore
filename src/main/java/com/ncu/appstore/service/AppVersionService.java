package com.ncu.appstore.service;

import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.pojo.AppVersion;

import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-11 14:36
 **/
public interface AppVersionService {
    List<AppVersion> selectByAppId(String appId);

    AppVersion getAppVersionById(Long id);

    BaseResult save(AppVersion appVersion);
}