package com.ycz.dao;

import com.ycz.model.vo.GalleryVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author admin
 */
@Component
public interface GalleryVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GalleryVo record);

    int insertSelective(GalleryVo record);

    GalleryVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GalleryVo record);

    int updateByPrimaryKey(GalleryVo record);

    List<GalleryVo> selectWithPage();
}