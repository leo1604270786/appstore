package com.ncu.appstore.service;

import com.ncu.appstore.pojo.BackendUser;


/**
 * app-store-com.ncu.appstore.service
 * created by LI LICHUNYAN at 2019/8/9
 */
public interface BackendUserService {
    public BackendUser addBackendUser(BackendUser backendUser);
    public BackendUser findBackendUserByCode(String usercode);
}
