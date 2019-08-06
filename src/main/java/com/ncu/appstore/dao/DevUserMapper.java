package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.DevUser;
import tk.mybatis.mapper.common.Mapper;
import org.springframework.stereotype.Repository;

@Repository


public interface DevUserMapper extends Mapper<DevUser> {
    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);
}