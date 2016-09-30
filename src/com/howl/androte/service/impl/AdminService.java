package com.howl.androte.service.impl;

import com.howl.androte.dao.AdminDao;
import com.howl.androte.javabean.Admin;
import com.howl.androte.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2016/9/25.
 */
@Service
public class AdminService implements IAdminService {
    @Autowired  //Autowired根据类型寻找到adminDao，然后spring会帮助创建
    private AdminDao adminDao;
    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin adminLogin(Admin admin) throws Exception {
        return adminDao.findByNameAndPwd(admin);
    }

    @Override
    public void adminRegister(Admin admin) throws Exception{
        adminDao.insertAdmin(admin);
    }
}
