package com.howl.androte.javabean;

import java.io.Serializable;

/**
 * Created by admin on 2016/9/25.
 */
//mapper文件与dao层放在一起，方便操作
public class Admin implements Serializable{
    private Integer adminId;

    private String adminName;

    private String adminPwd;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }
}
