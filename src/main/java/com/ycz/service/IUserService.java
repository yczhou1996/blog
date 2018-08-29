package com.ycz.service;

import com.ycz.model.Vo.UserVo;

public interface IUserService {

    /**
     * 新增对象
     * @param userVo
     * @return
     */
    Integer insert(UserVo userVo);


    /**
     * 修改对象
     * @param userVo
     * @return
     */
    Integer update(UserVo userVo);


    /**
     * 根据Id查找对象
     * @param id
     * @return
     */
    UserVo queryById(Integer id);


    /**
     * 登录用户
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username, String password);


    /**
     * 保存用户资料
     * @param userVo
     * @return
     */
    String saveInfo(UserVo userVo);
}
