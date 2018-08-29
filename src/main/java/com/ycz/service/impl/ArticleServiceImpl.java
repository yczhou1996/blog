package com.ycz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycz.constant.WebConst;
import com.ycz.dao.ArticleVoMapper;
import com.ycz.dao.CategoryVoMapper;
import com.ycz.dao.RelationshipVoMapper;
import com.ycz.model.Vo.ArticleVo;
import com.ycz.model.Vo.RelationshipVoKey;
import com.ycz.service.IArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleVoMapper articleVoDao;

    @Autowired
    private RelationshipVoMapper relationshipVoDao;

    @Autowired
    private CategoryVoMapper categoryVoDao;

    @Override
    public Integer insert(ArticleVo articleVo) {
        return articleVoDao.insertSelective(articleVo);
    }

    @Override
    public Integer update(ArticleVo articleVo) {
        return articleVoDao.updateByPrimaryKeySelective(articleVo);
    }

    @Override
    public ArticleVo queryById(Integer id) {
        if (null == id) {
            return null;
        }
        return articleVoDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Integer delete(Integer id) {
        if (null == id) {
            return null;
        }
        relationshipVoDao.deleteById(id);
        return articleVoDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public String publish(ArticleVo articleVo) {
        if (null == articleVo) {
            return "系统错误";
        }
        if (StringUtils.isBlank(articleVo.getTitle())) {
            return "文章标题不能为空";
        }
        if (StringUtils.isBlank(articleVo.getContent())) {
            return "文章内容不能为空";
        }
        if (StringUtils.isBlank(articleVo.getCategoryIds())) {
            return "文章分类不能为空";
        }
        if(null == articleVo.getAuthorId()){
            return "请登录后操作";
        }
        String[] categories = articleVo.getCategoryIds().split(",");
        List<String> categoryNames = new ArrayList<>();
        for (String categoryId : categories) {
            categoryNames.add(categoryVoDao.selectByPrimaryKey(Integer.valueOf(categoryId)).getName());
        }
        articleVo.setCategories(String.join(",", categoryNames));
        if (null == articleVo.getId()) {
            articleVo.setAddTime(new Date());
            insert(articleVo);
        } else {
            articleVo.setUpdateTime(new Date());
            update(articleVo);
        }
        //保存分类
        relationshipVoDao.deleteById(articleVo.getId());
        for (String cid : categories) {
            relationshipVoDao.insertSelective(new RelationshipVoKey(articleVo.getId(), Integer.valueOf(cid)));
        }
        return WebConst.SUCCESS_RESULT;
    }

    @Override
    public PageInfo<ArticleVo> selectArticles(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<ArticleVo> articleVos = articleVoDao.selectArticles();
        return new PageInfo<>(articleVos);
    }


}
