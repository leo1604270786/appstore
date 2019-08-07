package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AppInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface AppInfoMapper extends Mapper<AppInfo> {

    List<AppInfo> page(Map<String,Object> param);
}