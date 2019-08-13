package com.ncu.appstore.dao;

import com.ncu.appstore.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface DataDictionaryMapper extends Mapper<DataDictionary> {
    int update(@Param("id") long id,@Param("valuename") String valuename);
}