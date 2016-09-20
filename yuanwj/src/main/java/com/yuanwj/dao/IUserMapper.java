package com.yuanwj.dao;

import com.yuanwj.entity.User;

/**
 * Created by bmk on 16-9-19.
 */
public interface IUserMapper {
    User selectUserByID(Integer id);
}
