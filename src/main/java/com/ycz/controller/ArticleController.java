package com.ycz.controller;

import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.model.Bo.RestResponseBo;
import com.ycz.model.Vo.ArticleVo;
import com.ycz.model.Vo.CategoryVo;
import com.ycz.service.IArticleService;
import com.ycz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping( value = "admin/article" )
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping( value = "/list" )
    public String index(@RequestParam( value = "page", defaultValue = "1" ) int page,
                        @RequestParam( value = "limit", defaultValue = "10" ) int limit,
                        HttpServletRequest request) {
        PageInfo<ArticleVo> articles = articleService.selectArticles(page, limit);
        request.setAttribute("articles", articles);
        return "admin/article_list";
    }

    @GetMapping( value = "/{aid}" )
    public String editArticle(@PathVariable Integer aid, HttpServletRequest request) {
        ArticleVo articleVo = articleService.queryById(aid);
        request.setAttribute("article", articleVo);
        List<CategoryVo> categoryVoList = categoryService.selectCategory();
        request.setAttribute("categories", categoryVoList);
        return "admin/article_edit";
    }

    @GetMapping( value = "/edit" )
    public String edit(HttpServletRequest request) {
        List<CategoryVo> categoryVoList = categoryService.selectCategory();
        request.setAttribute("categories", categoryVoList);
        return "admin/article_edit";
    }

    @PostMapping( value = "/publish" )
    @ResponseBody
    public RestResponseBo publishArticle(ArticleVo articleVo) {
        String result = articleService.publish(articleVo);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }
}
