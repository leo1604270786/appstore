package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AppVersion;
import tk.mybatis.mapper.common.Mapper;

public interface AppVersionMapper extends Mapper<AppVersion> {
    int deleteByPrimaryKey(Long id);

    int insert(AppVersion record);

    int insertSelective(AppVersion record);

    AppVersion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppVersion record);

    int updateByPrimaryKey(AppVersion record);
}