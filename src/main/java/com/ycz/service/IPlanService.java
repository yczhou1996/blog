package com.ycz.service;

import com.github.pagehelper.PageInfo;
import com.ycz.model.Vo.PlanVo;

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
     * @param Id
     * @return
     */
    PlanVo queryById(Integer Id);

    /**
     * 删除对象
     */
    Integer delete(Integer Id);

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
