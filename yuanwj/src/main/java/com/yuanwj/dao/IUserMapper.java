package com.yuanwj.dao;

import com.yuanwj.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by bmk on 16-9-19.
 */
@Repository("iUserMapper")
public interface IUserMapper {
    User findById(Integer id);
    User findByName(String name);
}
