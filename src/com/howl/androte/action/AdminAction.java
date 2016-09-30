package com.howl.androte.action;

import com.howl.androte.javabean.Admin;
import com.howl.androte.service.IAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by admin on 2016/9/25.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminAction {
    private IAdminService adminService;

    @Resource(name = "adminService")
    public void setAdminService(IAdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String adminLogin(Admin admin, Model model, HttpSession session) throws Exception{
        Admin resultAdmin = adminService.adminLogin(admin);
        if(resultAdmin==null){
            model.addAttribute("admin","登录失败");
        }else{
//            model.addAttribute("admin","登录成功：管理员id--"+resultAdmin.getAdminId()
//            +"|管理员帐号"+resultAdmin.getAdminName()+"|管理员密码"+resultAdmin.getAdminPwd());
            session.setAttribute("admin",resultAdmin);
        }
        return "/WEB-INF/main/Main.html";
    }

    @RequestMapping(value = "/register")
    public String adminRegister(Admin admin, Model model) throws Exception{
        adminService.adminRegister(admin);
        model.addAttribute("admin","注册成功");
        return "/admin/test.jsp";
    }
}
