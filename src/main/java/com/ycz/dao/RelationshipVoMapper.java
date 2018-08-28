package com.ycz.dao;

import com.ycz.model.Vo.RelationshipVoKey;
import org.springframework.stereotype.Component;

@Component
public interface RelationshipVoMapper {
    int deleteByPrimaryKey(RelationshipVoKey key);

    int insert(RelationshipVoKey record);

    int insertSelective(RelationshipVoKey record);

    int deleteById(Integer aid);
}