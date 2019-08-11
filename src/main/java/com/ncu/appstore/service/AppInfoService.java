package com.ncu.appstore.service;

import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppInfo;

import java.util.Date;
import java.util.List;

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
    PageInfo<AppInfoDTO> page(int draw, int start, int length, AppInfo appInfo);

    /**
     * 通过id查询app基础信息
     * @param id
     * @return
     */
    AppInfo getAppInfoById(Long id);

    /**
     * 保存App信息
     * @param appInfo
     * @return
     */
    BaseResult save(AppInfo appInfo);

    /**
     * 通过apkName计算AppInfo个数
     * @param apkName
     * @return
     */
    int countAppInfoByApkName(String apkName);

    /**
     * 删除app基础信息
     * @param id
     * @return
     */
    BaseResult delete(Long id);

    /**
     * 更新最近版本信息
     * @param versionId
     * @param id
     * @return
     */
    int updateVersion(Long versionId, Long id);

    /**
     * 上架
     * @param statusId
     * @param id
     * @param onSaleDate
     * @return
     */
    int onSale(Long statusId, Long id, Date onSaleDate);

    /**
     * 下架
     * @param statusId
     * @param id
     * @param onSaleDate
     * @return
     */
    int offSale(Long statusId, Long id, Date onSaleDate);
}