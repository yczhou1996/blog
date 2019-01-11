package com.ycz.dao;

import com.ycz.model.vo.PlanVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author admin
 */
@Component
public interface PlanVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanVo record);

    int insertSelective(PlanVo record);

    PlanVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanVo record);

    int updateByPrimaryKey(PlanVo record);

    List<PlanVo> selectWithPage();
}