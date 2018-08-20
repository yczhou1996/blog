package com.ycz.service.impl;

import com.ycz.dao.UserVoMapper;
import com.ycz.model.Vo.UserVo;
import com.ycz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserVoMapper userVoDao;

    @Override
    public Integer insert(UserVo userVo) {
        return userVoDao.insertSelective(userVo);
    }

    @Override
    public Integer update(UserVo userVo) {
        return userVoDao.updateByPrimaryKeySelective(userVo);
    }

    @Override
    public UserVo queryUserById(Integer Id) {
        return userVoDao.selectByPrimaryKey(Id);
    }

    @Override
    public UserVo login(String username, String password) {
        return userVoDao.selectByUsAndPas(username, password);
    }
}
