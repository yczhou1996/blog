package com.ycz.dao;

import com.ycz.model.Vo.ClassifyVo;

public interface ClassifyVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassifyVo record);

    int insertSelective(ClassifyVo record);

    ClassifyVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassifyVo record);

    int updateByPrimaryKey(ClassifyVo record);
}