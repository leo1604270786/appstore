package com.ncu.appstore.pojo;

import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Component
public class AppVersion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;//主键(app版本表)

    private Long appid;//app的id（外键app_info{id}）
    @NotNull(message = "版本号不能为空")
    private String versionno;//版本编号
    @NotNull(message = "版本简介不能为空")
    private String versioninfo;//版本信息

    private DataDictionary publishstatus;//发布状态，对应data_dictionary，1 不发布 2 已发布 3 预发布

    private String downloadlink;//'下载链接
    @NotNull(message = "版本大小不能为空")
    private BigDecimal versionsize;//版本大小

    private Long createby;//创建者id（外键dev_user{id}）

    private Date creationdate;//创建日期时间

    private Long modifyby;//修改者id（外键dev_user{id}）

    private Date modifydate;//修改时间

    private String apklocpath;//apk在服务器的存储路径

    private String apkfilename;//apl文件名

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppid() {
        return appid;
    }

    public void setAppid(Long appid) {
        this.appid = appid;
    }

    public String getVersionno() {
        return versionno;
    }

    public void setVersionno(String versionno) {
        this.versionno = versionno == null ? null : versionno.trim();
    }

    public String getVersioninfo() {
        return versioninfo;
    }

    public void setVersioninfo(String versioninfo) {
        this.versioninfo = versioninfo == null ? null : versioninfo.trim();
    }

    public DataDictionary getPublishstatus() {
        return publishstatus;
    }

    public void setPublishstatus(DataDictionary publishstatus) {
        this.publishstatus = publishstatus;
    }

    public String getDownloadlink() {
        return downloadlink;
    }

    public void setDownloadlink(String downloadlink) {
        this.downloadlink = downloadlink == null ? null : downloadlink.trim();
    }

    public BigDecimal getVersionsize() {
        return versionsize;
    }

    public void setVersionsize(BigDecimal versionsize) {
        this.versionsize = versionsize;
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

    public String getApklocpath() {
        return apklocpath;
    }

    public void setApklocpath(String apklocpath) {
        this.apklocpath = apklocpath == null ? null : apklocpath.trim();
    }

    public String getApkfilename() {
        return apkfilename;
    }

    public void setApkfilename(String apkfilename) {
        this.apkfilename = apkfilename == null ? null : apkfilename.trim();
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", appid=" + appid +
                ", versionno='" + versionno + '\'' +
                ", versioninfo='" + versioninfo + '\'' +
                ", publishstatus=" + publishstatus +
                ", downloadlink='" + downloadlink + '\'' +
                ", versionsize=" + versionsize +
                ", createby=" + createby +
                ", creationdate=" + creationdate +
                ", modifyby=" + modifyby +
                ", modifydate=" + modifydate +
                ", apklocpath='" + apklocpath + '\'' +
                ", apkfilename='" + apkfilename + '\'' +
                '}';
    }
}