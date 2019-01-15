package com.ycz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 */
@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String index() {
        return "theme/default/index";
    }
}
