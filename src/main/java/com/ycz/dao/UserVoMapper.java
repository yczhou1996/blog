package com.ycz.dao;

import com.ycz.model.vo.UserVo;
import org.springframework.stereotype.Component;

/**
 * @author admin
 */
@Component
public interface UserVoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVo record);

    int insertSelective(UserVo record);

    UserVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserVo record);

    int updateByPrimaryKey(UserVo record);

    UserVo selectByUsername(String username);

    UserVo selectByNameAndPass(String username, String password);
}