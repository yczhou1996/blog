package com.ycz.service.impl;

import com.ycz.constant.WebConst;
import com.ycz.dao.CategoryVoMapper;
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
        return categoryVoDao.insertSelective(categoryVo);
    }

    @Override
    public Integer update(CategoryVo categoryVo) {
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

    public String saveOrUpdate(CategoryVo categoryVo){
        if(null == categoryVo.getName()){
            return "分类名称不能为空";
        }
        int count = categoryVoDao.existsCategory(categoryVo.getId(), categoryVo.getName());
        if(count > 0){
            return "分类名称已经存在";
        }
        if(null == categoryVo.getId()){
            insert(categoryVo);
        }else{
            update(categoryVo);
        }
        return WebConst.SUCCESS_RESULT;
    }
}
