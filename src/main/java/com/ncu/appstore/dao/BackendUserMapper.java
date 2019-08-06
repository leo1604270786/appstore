package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.BackendUser;
import tk.mybatis.mapper.common.Mapper;

public interface BackendUserMapper extends Mapper<BackendUser> {
    int deleteByPrimaryKey(Long id);

    int insert(BackendUser record);

    int insertSelective(BackendUser record);

    BackendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BackendUser record);

    int updateByPrimaryKey(BackendUser record);
}