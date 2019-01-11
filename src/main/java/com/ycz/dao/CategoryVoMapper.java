package com.ycz.dao;

import com.ycz.model.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author admin
 */
@Component
public interface CategoryVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryVo record);

    int insertSelective(CategoryVo record);

    CategoryVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryVo record);

    int updateByPrimaryKey(CategoryVo record);

    List<CategoryVo> selectCategory();

    int existsCategory(@Param("id") Integer id, @Param("name") String name);
}