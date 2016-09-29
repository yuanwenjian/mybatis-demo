package com.yuanwj.service;

import com.yuanwj.dao.IUserMapper;
import com.yuanwj.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by bmk on 16-9-29.
 */
@Service
public class UserServiece {
    @Inject
    private IUserMapper iUserMapper;

    public User findByName(String name){
        return iUserMapper.findByName(name);
    }
}
