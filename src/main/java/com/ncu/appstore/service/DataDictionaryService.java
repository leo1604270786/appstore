package com.ncu.appstore.service;

import com.ncu.appstore.pojo.DataDictionary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 17:11
 **/
public interface DataDictionaryService {
    /**
     * 通过类型获取数据字典列表
     * @param typeCode
     * @return
     */
    List<DataDictionary> getDataDictionaryByTypeCode(String typeCode);
}