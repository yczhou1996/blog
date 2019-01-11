package com.ycz.controller;

import com.ycz.constant.WebConst;
import com.ycz.exception.BusinessException;
import com.ycz.model.bo.RestResponseBo;
import com.ycz.model.vo.UserVo;
import com.ycz.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author admin
 */
@Controller
@RequestMapping("/")
public class AuthController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam(required = false) String remeber_me,
                                  HttpServletRequest request,
                                  HttpServletResponse response){
        UserVo user = userService.login(username, password);
        request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        if(StringUtils.isNotBlank(remeber_me)){
            Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, user.getId().toString());
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "/logout")
    public void logout(HttpSession session, HttpServletResponse response){
        session.removeAttribute(WebConst.LOGIN_SESSION_KEY);
        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, "");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        try{
            response.sendRedirect("/login");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
