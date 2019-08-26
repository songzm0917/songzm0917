package com.songzm.rediscache.dao;

import com.songzm.rediscache.config.mybatis.CommonMapper;
import com.songzm.rediscache.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper extends CommonMapper<User> {


    /**
     * 自定义
     * @param id
     * @return
     */
    User selectByPrimaryKey1(Long id);

    void add(User user);
}