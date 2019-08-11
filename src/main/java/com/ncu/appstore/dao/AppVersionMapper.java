package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AppVersion;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AppVersionMapper extends Mapper<AppVersion> {
    List<AppVersion> selectByAppId(String appId);

    AppVersion getAppVersionById(String id);

    int insert(AppVersion appVersion);

    int update(AppVersion appVersion);

    int deleteByAppId(String appId);
}