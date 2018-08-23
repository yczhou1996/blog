package com.ycz.service.impl;

import com.ycz.constant.WebConst;
import com.ycz.dao.UserVoMapper;
import com.ycz.exception.TipException;
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
    public UserVo queryById(Integer Id) {
        return userVoDao.selectByPrimaryKey(Id);
    }

    @Override
    public UserVo login(String username, String password) {
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            throw new TipException("账号或密码不能为空");
        }
        UserVo user = userVoDao.selectByUsername(username);
        if(null == user){
            throw new TipException("用户名不存在");
        }
        if(!password.equals(user.getPassword())) {
            throw new TipException("密码错误");
        }
        return user;
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
