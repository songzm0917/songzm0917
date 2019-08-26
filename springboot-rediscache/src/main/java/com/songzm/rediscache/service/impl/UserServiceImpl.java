package com.songzm.rediscache.service.impl;

import com.songzm.rediscache.dao.UserMapper;
import com.songzm.rediscache.entity.User;
import com.songzm.rediscache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@CacheConfig(cacheNames = "user")
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @return
     */
    @Cacheable
    @Override
    public List<User> getAll() {
        List<User> userList = userMapper.selectAll();//调用tk.mybatis.mapper的selectAll方法并且缓存
        return userList;
    }


    /**
     *
     * @param id
     * @return
     */
    @Cacheable
    @Override
    public User findOneByUserId(Long id) {
        User user = userMapper.selectByPrimaryKey1(id);//自定义方法selectByPrimaryKey1
        return user;
    }


    @CachePut(key = "'UserServiceImpl-findOneByUserId-' + #result.id")
    @Override
    public User add(User user) {
        userMapper.add(user);//定义方法add
        return user;
    }

    /**
     * 用此方法请将com.songzm.rediscache.entity.User的注释打开
     * @param user
     * @return
     */
    @CachePut(key = "'UserServiceImpl-findOneByUserId-' + #result.id")
    public User insertGrade(User user) {
        userMapper.insert(user);//调用tk.mybatis.mapper的insert方法并且缓存
        return user;
    }




}
