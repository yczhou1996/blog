package com.ycz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ycz.dao.GalleryVoMapper;
import com.ycz.model.vo.GalleryVo;
import com.ycz.service.IGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 */
@Service
public class GalleryServiceImpl implements IGalleryService {

    @Autowired
    private GalleryVoMapper galleryVoDao;

    @Override
    public Integer insert(String name, String key, Integer uid) {
        GalleryVo galleryVo = new GalleryVo();
        galleryVo.setName(name);
        galleryVo.setPhoto(key);
        galleryVo.setAuthorId(uid);
        galleryVo.setAddTime(new Date());
        return galleryVoDao.insertSelective(galleryVo);
    }

    @Override
    public GalleryVo queryById(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        if(null == id){
            return null;
        }
        return galleryVoDao.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<GalleryVo> selectWithPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<GalleryVo> galleryVos = galleryVoDao.selectWithPage();
        return new PageInfo<>(galleryVos);
    }
}
