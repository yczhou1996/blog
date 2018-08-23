package com.ycz.interceptor;

import com.ycz.constant.WebConst;
import com.ycz.model.Vo.UserVo;
import com.ycz.service.IUserService;
import com.ycz.utils.CommonsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BaseInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String contextPath = request.getContextPath();
        System.out.println(contextPath);
        System.out.println("-------------拦截开始--------------");
        String uri = request.getRequestURI();

        UserVo user = CommonsUtil.getLoginUser(request);
        if(null == user){
            Integer id = CommonsUtil.getCookieId(request);
            if(null != id){
                user = userService.queryById(id);
                request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
            }
        }
        if (uri.startsWith(contextPath + "/") && !uri.startsWith(contextPath + "/login") && null == user) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
