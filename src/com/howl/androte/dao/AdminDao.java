package com.howl.androte.dao;


import com.howl.androte.javabean.Admin;

/**
 * Created by admin on 2016/9/25.
 */
public interface AdminDao {
    //方法名必须与Mapper文件中的sql语句方法id一致
    public Admin findByNameAndPwd(Admin admin);
    public int insertAdmin(Admin admin);
}
