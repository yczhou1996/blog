package com.ycz.controller;

import com.ycz.model.Vo.UserVo;
import com.ycz.utils.CommonsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Chitanda Eru on 2018/8/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request){
        UserVo userVo = CommonsUtil.getLoginUser(request);
        request.setAttribute("user", userVo);
        return "index";
    }


    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
