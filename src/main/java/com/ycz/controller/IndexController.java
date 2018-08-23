package com.ycz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Chitanda Eru on 2018/8/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }


    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
