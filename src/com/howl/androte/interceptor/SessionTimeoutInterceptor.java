package com.howl.androte.interceptor;

import com.howl.androte.exception.SessionTimeoutException;
import com.howl.androte.javabean.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理session超时的拦截器
 */
public class SessionTimeoutInterceptor  implements HandlerInterceptor {

    public String[] allowUrls;//还没发现可以直接配置不拦截的资源，所以在代码里面来排除

    public void setAllowUrls(String[] allowUrls) {
        this.allowUrls = allowUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        System.out.println(requestUrl);
        if(null != allowUrls && allowUrls.length>=1)
            for(String url : allowUrls) {
                if(requestUrl.contains(url)) {
                    return true;
                }
            }

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if(admin != null) {
            return true;  //返回true，则这个方面调用后会接着调用postHandle(),  afterCompletion()
        }else{
            // 未登录  跳转到登录页面
            throw new SessionTimeoutException();//返回到配置文件中定义的路径
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
    }

}
