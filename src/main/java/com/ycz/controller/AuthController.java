package com.ycz.controller;

import com.ycz.constant.WebConst;
import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.UserVo;
import com.ycz.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        request.setAttribute(WebConst.LOGIN_SESSION_KEY, user);
        if(StringUtils.isNotBlank(remeber_me)){

        }
        return RestResponseBo.ok();
    }
}
