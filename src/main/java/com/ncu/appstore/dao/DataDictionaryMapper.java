package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.DataDictionary;
import tk.mybatis.mapper.common.Mapper;

public interface DataDictionaryMapper extends Mapper<DataDictionary> {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);
}