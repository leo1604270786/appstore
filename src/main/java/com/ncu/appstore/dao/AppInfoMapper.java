package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AppInfo;
import tk.mybatis.mapper.common.Mapper;

public interface AppInfoMapper extends Mapper<AppInfo> {
    int deleteByPrimaryKey(Long id);

    int insert(AppInfo record);

    int insertSelective(AppInfo record);

    AppInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppInfo record);

    int updateByPrimaryKey(AppInfo record);
}