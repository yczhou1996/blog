package com.ycz.controller;

import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.ArticleVo;
import com.ycz.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "admin/artilce")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping(value = "list")
    public String index(){
        return "admin/article_list";
    }

    @GetMapping(value = "edit")
    public String edit(){
        return "admin/article_edit";
    }

    @PostMapping(value = "publish")
    @ResponseBody
    public RestResponseBo publishArticle(ArticleVo articleVo){
        return null;
    }
}
