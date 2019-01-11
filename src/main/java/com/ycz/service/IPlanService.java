package com.ycz.service;

import com.github.pagehelper.PageInfo;
import com.ycz.model.vo.PlanVo;

/**
 * @author admin
 */
public interface IPlanService {
    /**
     * 新增对象
     * @param planVo
     * @return
     */
    Integer insert(PlanVo planVo);


    /**
     * 修改对象
     * @param planVo
     * @return
     */
    Integer update(PlanVo planVo);


    /**
     * 根据Id查找对象
     * @param id
     * @return
     */
    PlanVo queryById(Integer id);

    /**
     * 删除对象
     */
    Integer delete(Integer id);

    /**
     * 分页计划列表
     * @param page
     * @param limit
     * @return
     */
    PageInfo<PlanVo> getPlanWithpage(Integer page, Integer limit);

    /**
     * 添加或修改
     * @param planVo
     * @return
     */
    String saveOrUpdate(PlanVo planVo);
}
