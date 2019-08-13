package com.ncu.appstore.service.impl;

import com.ncu.appstore.controller.BaseController;
import com.ncu.appstore.dao.AppInfoMapper;
import com.ncu.appstore.dto.AppInfoDTO;
import com.ncu.appstore.dto.BaseResult;
import com.ncu.appstore.dto.PageInfo;
import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.pojo.AppInfo;
import com.ncu.appstore.pojo.DataDictionary;
import com.ncu.appstore.pojo.DevUser;
import com.ncu.appstore.service.AppInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public int pass(long id){
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo = appInfoMapper.selectByPrimaryKey(appInfo);
        appInfo.getStatus().setValuename("审核通过");
        return appInfoMapper.update(appInfo);
    }
    public int reject(long id){
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo = appInfoMapper.selectByPrimaryKey(appInfo);
        appInfo.getStatus().setValuename("审核不通过");
        return appInfoMapper.update(appInfo);
    }
    public PageInfo<AppInfoDTO> page(int draw, int start, int length, AppInfo appInfo) {
        //获取当前登录用户
        DevUser devUser = (DevUser)BaseController.getSession().getAttribute("devUser");
        PageInfo<AppInfoDTO> pageInfo = new PageInfo<>();
        Map<String,Object> params = new HashMap<>();
        params.put("start",start);
        params.put("length",length);
        params.put("pageParams",appInfo);
        params.put("devId",devUser.getId());
        List<AppInfo> appInfos = appInfoMapper.page(params);
        //由于可能有查询条件查询，所以须查询出记录总数
        int count = appInfoMapper.count(params);
        //将需要的属性拷贝至DTO,拼接分类
        StringBuilder stringBuilder = new StringBuilder();
        List<AppInfoDTO> appInfoDTOS = new ArrayList<>();
        for (int i = 0; i < appInfos.size(); i++){
            AppInfoDTO appInfoDTO = new AppInfoDTO();
            AppInfo appInfo1 = appInfos.get(i);
            BeanUtils.copyProperties(appInfo1,appInfoDTO);
            stringBuilder.append(appInfo1.getCategorylevel1().getCategoryname()).append("->");
            stringBuilder.append(appInfo1.getCategorylevel2().getCategoryname()).append("->");
            stringBuilder.append(appInfo1.getCategorylevel3().getCategoryname());
            AppCategory appCategory = new AppCategory();
            appCategory.setCategoryname(stringBuilder.toString());
            appInfoDTO.setCategorylevel(appCategory);
            stringBuilder.setLength(0);
            appInfoDTOS.add(appInfoDTO);
        }
        pageInfo.setData(appInfoDTOS);
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setError("");
        return pageInfo;
    }

    @Override
    public AppInfo getAppInfoById(Long id) {
        return appInfoMapper.getAppInfoById(""+id);
    }

    @Override
    @Transactional(readOnly = false)
    public BaseResult save(AppInfo appInfo) {
        DevUser devUser = (DevUser)BaseController.getSession().getAttribute("devUser");
        //新增
        if (appInfo.getId() == null || "".equals(appInfo.getId().toString())){
            appInfo.setCreateby(devUser.getId());
            appInfo.setCreationdate(new Date());
            appInfo.setModifyby(devUser.getId());
            appInfo.setModifydate(new Date());
            appInfo.setDevUser(devUser);
            appInfoMapper.insert(appInfo);
        }
        //编辑
        else{
            appInfo.setUpdatedate(new Date());
            appInfo.setModifyby(devUser.getId());
            appInfo.setModifydate(new Date());
            appInfoMapper.update(appInfo);
        }
        return BaseResult.success("保存App基础信息成功");
    }

    @Override
    public int countAppInfoByApkName(String apkName) {
        return appInfoMapper.countAppInfoByApkName(apkName);
    }

    @Override
    public BaseResult delete(Long id) {
        int delete = appInfoMapper.deleteByPrimaryKey(id);
        if (delete <= 0){
            return BaseResult.fail("删除失败！");
        }
        return BaseResult.success("删除成功。");
    }

    @Override
    public int updateVersion(Long versionId, Long id) {
        return appInfoMapper.updateVersion(versionId+"", id+"");
    }

    @Override
    public int onSale(Long statusId, Long id, Date onSaleDate) {
        return appInfoMapper.onSale(statusId+"",id+"",onSaleDate);
    }

    @Override
    public int offSale(Long statusId, Long id, Date onSaleDate) {
        return appInfoMapper.offSale(statusId+"",id+"",onSaleDate);
    }
}