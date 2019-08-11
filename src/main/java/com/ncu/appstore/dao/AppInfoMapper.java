package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AppInfoMapper extends Mapper<AppInfo> {

    List<AppInfo> page(Map<String,Object> param);

    int count(Map<String,Object> param);

    int insert(AppInfo appInfo);

    AppInfo getAppInfoById(String id);

    int update(AppInfo appInfo);

    int countAppInfoByApkName(String apkname);

    int updateVersion(@Param("versionId") String versionId, @Param("id") String id);

    int onSale(@Param("statusId") String statusId, @Param("id") String id, @Param("onSaleDate")Date onSaleDate);

    int offSale(@Param("statusId") String statusId, @Param("id") String id, @Param("offSaleDate")Date offSaleDate);
}