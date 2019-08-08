package com.ncu.appstore.dto;

import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.pojo.AppVersion;
import com.ncu.appstore.pojo.DataDictionary;
import com.ncu.appstore.pojo.DevUser;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 14:11
 **/
public class AppInfoDTO implements Serializable {
    private Long id;//主键(APP信息表)

    private String softwarename;//软件名

    private String apkname;//APK名

    private String supportrom;//支持的ROM

    private String interfacelanguage;//界面所用语言

    private BigDecimal softwaresize;//'软件的大小(Mb)

    private DevUser devUser;//开发者

    private String appinfo;//app基本信息

    private DataDictionary status;//状态（对应：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）

    private Date onsaledate;//上架时间

    private Date offsaledate;//下架时间

    private DataDictionary floatformid;//平台类型(对应date_dictionary，1，手机，2，平板，3，通用)

    private AppCategory categorylevel;//分类（多级）（来自app_category）

    private Long downloads;//下载量

    private Date creationdate;//'添加时间

    private String logolocpath;//logo存储在本地电脑的路径

    private AppVersion appversion;//版本

    private String logowebpath;//logo在web服务器存储路径

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwarename() {
        return softwarename;
    }

    public void setSoftwarename(String softwarename) {
        this.softwarename = softwarename;
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname;
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom;
    }

    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage;
    }

    public BigDecimal getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(BigDecimal softwaresize) {
        this.softwaresize = softwaresize;
    }

    public DevUser getDevUser() {
        return devUser;
    }

    public void setDevUser(DevUser devUser) {
        this.devUser = devUser;
    }

    public String getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo;
    }

    public DataDictionary getStatus() {
        return status;
    }

    public void setStatus(DataDictionary status) {
        this.status = status;
    }

    public Date getOnsaledate() {
        return onsaledate;
    }

    public void setOnsaledate(Date onsaledate) {
        this.onsaledate = onsaledate;
    }

    public Date getOffsaledate() {
        return offsaledate;
    }

    public void setOffsaledate(Date offsaledate) {
        this.offsaledate = offsaledate;
    }

    public DataDictionary getFloatformid() {
        return floatformid;
    }

    public void setFloatformid(DataDictionary floatformid) {
        this.floatformid = floatformid;
    }

    public AppCategory getCategorylevel() {
        return categorylevel;
    }

    public void setCategorylevel(AppCategory categorylevel) {
        this.categorylevel = categorylevel;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getLogolocpath() {
        return logolocpath;
    }

    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath;
    }

    public AppVersion getAppversion() {
        return appversion;
    }

    public void setAppversion(AppVersion appversion) {
        this.appversion = appversion;
    }

    public String getLogowebpath() {
        return logowebpath;
    }

    public void setLogowebpath(String logowebpath) {
        this.logowebpath = logowebpath;
    }
}