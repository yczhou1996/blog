package com.ycz.service;

import com.github.pagehelper.PageInfo;
import com.ycz.model.Vo.GalleryVo;

public interface IGalleryService {

    /**
     * 新增对象
     * @param name
     * @param key
     * @param uid
     * @return
     */
    Integer insert(String name, String key, Integer uid);


    /**
     * 根据Id查找对象
     * @param id
     * @return
     */
    GalleryVo queryById(Integer id);


    /**
     * 删除对象
     */
    Integer delete(Integer id);


    /**
     * 查询所有
     * @param page
     * @param limit
     * @return
     */
    PageInfo<GalleryVo> selectWithPage(Integer page, Integer limit);
}
