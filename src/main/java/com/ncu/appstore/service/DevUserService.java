package com.ncu.appstore.service;

import com.ncu.appstore.pojo.DevUser;
import org.springframework.stereotype.Service;

/**
 * @program: app-store
 * @description:
 * @author: Leo
 * @create: 2019-08-06 15:35
 **/

public interface DevUserService {
    public DevUser addDevUser(DevUser devUser);
    public DevUser findDevUserByEmail(String email);
    public DevUser findDevUserByCode(String devcode);
    public int updateDevUser(DevUser devUser);
}