package com.ycz.service;

import com.ycz.model.Vo.CategoryVo;

import java.util.List;

public interface ICategoryService {

    /**
     * 新增对象
     * @param categoryVo
     * @return
     */
    Integer insert(CategoryVo categoryVo);


    /**
     * 修改对象
     * @param categoryVo
     * @return
     */
    Integer update(CategoryVo categoryVo);


    /**
     * 根据Id查找对象
     * @param Id
     * @return
     */
    CategoryVo queryById(Integer Id);


    /**
     * 删除对象
     */
    Integer delete(Integer Id);


    /**
     * 查询所有分类
     * @return
     */
    List<CategoryVo> selectCategory();


}
