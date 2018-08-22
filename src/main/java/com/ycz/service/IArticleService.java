package com.ycz.service;

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
}
