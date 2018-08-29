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
     * @param id
     * @return
     */
    CategoryVo queryById(Integer id);


    /**
     * 删除对象
     */
    Integer delete(Integer id);


    /**
     * 查询所有分类
     * @return
     */
    List<CategoryVo> selectCategory();


    /**
     * 添加或修改
     * @param categoryVo
     * @return
     */
    String saveOrUpdate(CategoryVo categoryVo);
}
