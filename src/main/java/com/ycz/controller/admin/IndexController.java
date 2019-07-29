package com.ycz.controller.admin;

import com.ycz.model.vo.UserVo;
import com.ycz.utils.CommonsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author admin
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request){
        UserVo userVo = CommonsUtil.getLoginUser(request);
        request.setAttribute("user", userVo);
        return "/admin/index";
    }


    @GetMapping(value = "/home")
    public String home(){
        return "/admin/home";
    }
}
