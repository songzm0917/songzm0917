package com.songzm.rediscache.service;

import com.songzm.rediscache.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findOneByUserId (Long id);

    User add (User user);

    User insertGrade (User user);
}
