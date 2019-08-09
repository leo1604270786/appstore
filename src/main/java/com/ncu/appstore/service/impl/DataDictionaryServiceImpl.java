package com.ncu.appstore.service.impl;

import com.ncu.appstore.dao.DataDictionaryMapper;
import com.ncu.appstore.pojo.DataDictionary;
import com.ncu.appstore.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 17:13
 **/
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getDataDictionaryByTypeCode(String typeCode) {
        Example example = new Example(DataDictionary.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("typecode", typeCode);
        return dataDictionaryMapper.selectByExample(example);
    }
}