package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.DevUser;
import org.springframework.stereotype.Repository;

@Repository
public interface DevUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DevUser record);

    int insertSelective(DevUser record);

    DevUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DevUser record);

    int updateByPrimaryKey(DevUser record);
}