package com.ycz.dao;

import com.ycz.model.Vo.CategoryVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryVo record);

    int insertSelective(CategoryVo record);

    CategoryVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryVo record);

    int updateByPrimaryKey(CategoryVo record);

    List<CategoryVo> selectCategory();
}