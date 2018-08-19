package com.ycz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Chitanda Eru on 2018/8/16.
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index(){
        return "head";
    }

    @GetMapping(value = "/home")
    public String home(){
        return "home";
    }
}
