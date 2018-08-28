package com.ycz.dao;

import com.ycz.model.Vo.ArticleVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleVo record);

    int insertSelective(ArticleVo record);

    ArticleVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleVo record);

    int updateByPrimaryKey(ArticleVo record);

    List<ArticleVo> selectArticles();

}