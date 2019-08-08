package com.ncu.appstore.service.impl;

import com.ncu.appstore.dao.DevUserMapper;
import com.ncu.appstore.pojo.DevUser;

import com.ncu.appstore.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-06 15:36
 **/
@Service
public class DevUserServiceImpl implements DevUserService {
    @Autowired
    private DevUserMapper devUserMapper;
    public DevUser addDevUser(DevUser devUser){
        devUserMapper.insert(devUser);
        return devUser;
    }
    public DevUser findDevUserByEmail(String email){
        DevUser devUser = new DevUser();
        devUser.setDevemail(email);
        return devUserMapper.selectOne(devUser);
    }
    public DevUser findDevUserByCode(String devcode){
        DevUser devUser = new DevUser();
        devUser.setDevcode(devcode);
        return devUserMapper.selectOne(devUser);
    }
    public int updateDevUser(DevUser devUser){
       return devUserMapper.updateByPrimaryKey(devUser);
        //return true;
    }
}