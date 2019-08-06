package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.AdPromotion;
import tk.mybatis.mapper.common.Mapper;


public interface AdPromotionMapper extends Mapper<AdPromotion> {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}