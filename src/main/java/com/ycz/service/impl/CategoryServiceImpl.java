package com.ycz.service.impl;

import com.ycz.dao.CategoryVoMapper;
import com.ycz.exception.TipException;
import com.ycz.model.Vo.CategoryVo;
import com.ycz.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryVoMapper categoryVoDao;

    @Override
    public Integer insert(CategoryVo categoryVo) {
        if(null == categoryVo.getName()){
            throw new TipException("分类名称不能为空");
        }
        return categoryVoDao.insertSelective(categoryVo);
    }

    @Override
    public Integer update(CategoryVo categoryVo) {
        if(null == categoryVo.getId()){
            throw new TipException("系统错误");
        }
        if(null == categoryVo.getName()){
            throw new TipException("分类名称不能为空");
        }
        return categoryVoDao.updateByPrimaryKeySelective(categoryVo);
    }

    @Override
    public CategoryVo queryById(Integer Id) {
        return categoryVoDao.selectByPrimaryKey(Id);
    }

    @Override
    public Integer delete(Integer Id) {
        return categoryVoDao.deleteByPrimaryKey(Id);
    }

    @Override
    public List<CategoryVo> selectCategory() {
        return categoryVoDao.selectCategory();
    }
}
