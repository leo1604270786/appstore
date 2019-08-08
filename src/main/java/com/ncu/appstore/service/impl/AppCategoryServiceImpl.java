package com.ncu.appstore.service.impl;

import com.ncu.appstore.dao.AppCategoryMapper;
import com.ncu.appstore.pojo.AppCategory;
import com.ncu.appstore.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-08 14:46
 **/
@Service
@Transactional
public class AppCategoryServiceImpl implements AppCategoryService {
    @Autowired
    private AppCategoryMapper appCategoryMapper;
    @Override
    public List<AppCategory> getCategoryByCategoryCode(String categoryCode) {
        Example example = new Example(AppCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categorycode",categoryCode);
        return appCategoryMapper.selectByExample(example);
    }

    @Override
    public List<AppCategory> getCategoryByCategoryCodeAndParent(String categoryCode, String parent) {
        Example example = new Example(AppCategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categorycode",categoryCode);
        criteria.andEqualTo("parentid",parent);
        return appCategoryMapper.selectByExample(example);
    }
}