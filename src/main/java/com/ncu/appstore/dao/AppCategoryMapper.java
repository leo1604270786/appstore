package com.ncu.appstore.dao;


import com.ncu.appstore.pojo.AppCategory;
import tk.mybatis.mapper.common.Mapper;

public interface AppCategoryMapper extends Mapper<AppCategory> {
    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    AppCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);
}