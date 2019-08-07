package com.ncu.appstore.pojo;


import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Component
public class AppInfo implements Serializable {
    @Id//标识主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;//主键(APP信息表)

    private String softwarename;//软件名

    private String apkname;//APK名

    private String supportrom;//支持的ROM

    private String interfacelanguage;//界面所用语言

    private BigDecimal softwaresize;//'软件的大小(Mb)

    private Date updatedate;//更新时间

    private Long devid;//开发者Id

    private String appinfo;//app基本信息

    private Long status;//状态（对应：data_dictionary，1 待审核 2 审核通过 3 审核不通过 4 已上架 5 已下架）

    private Date onsaledate;//上架时间

    private Date offsaledate;//下架时间

    private Long floatformid;//平台类型(对应date_dictionary，1，手机，2，平板，3，通用)

    private Long categorylevel3;//三级分类id（来自data_dictionary）

    private Long downloads;//下载量

    private Long createby;//谁添加的(对应dev_user{id})

    private Date creationdate;//'添加时间

    private Long modifyby;//更新者id（对应dev_user{id}）

    private Date modifydate;//更新时间

    private Long categorylevel1;//一级分类id（来自data_dictionary）

    private Long categorylevel2;//二级分类id（来自data_dictionary）

    private String logolocpath;//logo存储在本地电脑的路径

    private Long versionid;//版本id

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
        this.softwarename = softwarename == null ? null : softwarename.trim();
    }

    public String getApkname() {
        return apkname;
    }

    public void setApkname(String apkname) {
        this.apkname = apkname == null ? null : apkname.trim();
    }

    public String getSupportrom() {
        return supportrom;
    }

    public void setSupportrom(String supportrom) {
        this.supportrom = supportrom == null ? null : supportrom.trim();
    }

    public String getInterfacelanguage() {
        return interfacelanguage;
    }

    public void setInterfacelanguage(String interfacelanguage) {
        this.interfacelanguage = interfacelanguage == null ? null : interfacelanguage.trim();
    }

    public BigDecimal getSoftwaresize() {
        return softwaresize;
    }

    public void setSoftwaresize(BigDecimal softwaresize) {
        this.softwaresize = softwaresize;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getAppinfo() {
        return appinfo;
    }

    public void setAppinfo(String appinfo) {
        this.appinfo = appinfo == null ? null : appinfo.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
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

    public Long getFloatformid() {
        return floatformid;
    }

    public void setFloatformid(Long floatformid) {
        this.floatformid = floatformid;
    }

    public Long getCategorylevel3() {
        return categorylevel3;
    }

    public void setCategorylevel3(Long categorylevel3) {
        this.categorylevel3 = categorylevel3;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreateby() {
        return createby;
    }

    public void setCreateby(Long createby) {
        this.createby = createby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getCategorylevel1() {
        return categorylevel1;
    }

    public void setCategorylevel1(Long categorylevel1) {
        this.categorylevel1 = categorylevel1;
    }

    public Long getCategorylevel2() {
        return categorylevel2;
    }

    public void setCategorylevel2(Long categorylevel2) {
        this.categorylevel2 = categorylevel2;
    }

    public String getLogolocpath() {
        return logolocpath;
    }

    public void setLogolocpath(String logolocpath) {
        this.logolocpath = logolocpath == null ? null : logolocpath.trim();
    }

    public Long getVersionid() {
        return versionid;
    }

    public void setVersionid(Long versionid) {
        this.versionid = versionid;
    }

    public String getLogowebpath() {
        return logowebpath;
    }

    public void setLogowebpath(String logowebpath) {
        this.logowebpath = logowebpath == null ? null : logowebpath.trim();
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", softwarename='" + softwarename + '\'' +
                ", apkname='" + apkname + '\'' +
                ", supportrom='" + supportrom + '\'' +
                ", interfacelanguage='" + interfacelanguage + '\'' +
                ", softwaresize=" + softwaresize +
                ", updatedate=" + updatedate +
                ", devid=" + devid +
                ", appinfo='" + appinfo + '\'' +
                ", status=" + status +
                ", onsaledate=" + onsaledate +
                ", offsaledate=" + offsaledate +
                ", floatformid=" + floatformid +
                ", categprylevel3=" + categorylevel3 +
                ", downloads=" + downloads +
                ", createbby=" + createby +
                ", creationdate=" + creationdate +
                ", modifyby=" + modifyby +
                ", modifydate=" + modifydate +
                ", categorylevel1=" + categorylevel1 +
                ", categorylevel2=" + categorylevel2 +
                ", logolocpath='" + logolocpath + '\'' +
                ", versionid=" + versionid +
                ", logowebpath='" + logowebpath + '\'' +
                '}';
    }
}