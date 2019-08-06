package com.ncu.appstore.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class AdPromotion {
    @Id//标识主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增长策略
    private Long id;//主键(广告宣传表)

    private Long appid;//'外键(app_info{id})

    private String adpicpath;//图片路径

    private Long adpv;//点击量

    private Integer carouselposition;//轮播所处位置

    private Date starttime;//开始生效时间

    private Date endtime;//广告失效时间

    private Long createby;//由谁生成(外键，bacaend_user{id})

    private Date creationdate;//生成时间

    private Long modifyby;//被谁修改(外键，bacaend_user{id}

    private Date modifydate;//上次修改时间

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

    public String getAdpicpath() {
        return adpicpath;
    }

    public void setAdpicpath(String adpicpath) {
        this.adpicpath = adpicpath == null ? null : adpicpath.trim();
    }

    public Long getAdpv() {
        return adpv;
    }

    public void setAdpv(Long adpv) {
        this.adpv = adpv;
    }

    public Integer getCarouselposition() {
        return carouselposition;
    }

    public void setCarouselposition(Integer carouselposition) {
        this.carouselposition = carouselposition;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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
}