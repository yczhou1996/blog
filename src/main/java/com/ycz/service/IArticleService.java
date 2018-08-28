package com.ycz.service;

import com.github.pagehelper.PageInfo;
import com.ycz.model.Vo.ArticleVo;

public interface IArticleService {

    /**
     * 新增对象
     * @param articleVo
     * @return
     */
    Integer insert(ArticleVo articleVo);


    /**
     * 修改对象
     * @param articleVo
     * @return
     */
    Integer update(ArticleVo articleVo);


    /**
     * 根据Id查找对象
     * @param Id
     * @return
     */
    ArticleVo queryById(Integer Id);


    /**
     * 删除对象
     */
    Integer delete(Integer id);


    /**
     * 发表文章
     * @param articleVo
     * @return
     */
    String publish(ArticleVo articleVo);


    /**
     * 获取所有文章
     * @param page
     * @param limit
     * @return
     */
    PageInfo<ArticleVo> selectArticles(Integer page, Integer limit);
}
