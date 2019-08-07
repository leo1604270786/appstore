package com.ncu.appstore.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class DevUser implements Serializable {
    @Id//标识主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;//主键(开发者表)

    private String devcode;//账号

    private String devname;//'姓名',

    private String devpassword;//密码

    private String devemail;//电子邮箱

    private String devinfo;//介绍

    private Long createby;//null

    private Date creationdate;//注册时间

    private Long modifyby;//null

    private Date modifydate;//null

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevcode() {
        return devcode;
    }

    public void setDevcode(String devcode) {
        this.devcode = devcode == null ? null : devcode.trim();
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname == null ? null : devname.trim();
    }

    public String getDevpassword() {
        return devpassword;
    }

    public void setDevpassword(String devpassword) {
        this.devpassword = devpassword == null ? null : devpassword.trim();
    }

    public String getDevemail() {
        return devemail;
    }

    public void setDevemail(String devemail) {
        this.devemail = devemail == null ? null : devemail.trim();
    }

    public String getDevinfo() {
        return devinfo;
    }

    public void setDevinfo(String devinfo) {
        this.devinfo = devinfo == null ? null : devinfo.trim();
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

    @Override
    public String toString() {
        return "DevUser{" +
                "id=" + id +
                ", devcode='" + devcode + '\'' +
                ", devname='" + devname + '\'' +
                ", devpassword='" + devpassword + '\'' +
                ", devemail='" + devemail + '\'' +
                ", devinfo='" + devinfo + '\'' +
                ", createby=" + createby +
                ", creationdate=" + creationdate +
                ", modifyby=" + modifyby +
                ", modifydate=" + modifydate +
                '}';
    }
}