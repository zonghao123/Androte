package com.howl.androte.service;

import com.howl.androte.javabean.Admin;

/**
 * Created by admin on 2016/9/25.
 */
public interface IAdminService {
    Admin adminLogin(Admin admin) throws Exception;
    void adminRegister(Admin admin) throws Exception;
}
