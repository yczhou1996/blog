package com.ycz.service;

import com.ycz.model.Vo.UserVo;

public interface IUserService {

    /**
     * 新增用户数据
     * @param userVo
     * @return
     */
    Integer insert(UserVo userVo);


    /**
     * 修改用户数据
     * @param userVo
     * @return
     */
    Integer update(UserVo userVo);


    /**
     * 根据Id查找对象
     * @param Id
     * @return
     */
    UserVo queryUserById(Integer Id);


    /**
     * 登录用户
     * @param username
     * @param password
     * @return
     */
    UserVo login(String username, String password);
}
