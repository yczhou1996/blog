package com.ycz.service.impl;

import com.ycz.constant.WebConst;
import com.ycz.dao.UserVoMapper;
import com.ycz.model.Vo.UserVo;
import com.ycz.service.IUserService;
import org.apache.commons.lang3.StringUtils;
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
        return null;
    }

    @Override
    public String saveInfo(UserVo userVo) {
        if(null == userVo || null == userVo.getId()){
            return "系统错误";
        }
        if(StringUtils.isBlank(userVo.getFullname())){
            return "姓名不能为空";
        }
        userVoDao.updateByPrimaryKeySelective(userVo);
        return WebConst.SUCCESS_RESULT;
    }
}
