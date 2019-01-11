package com.ycz.dao;

import com.ycz.model.vo.RelationshipVoKey;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public interface RelationshipVoMapper {
    int deleteByPrimaryKey(RelationshipVoKey key);

    int insert(RelationshipVoKey record);

    int insertSelective(RelationshipVoKey record);

    int deleteById(Integer aid);

    int countByCid(Integer cid);
}