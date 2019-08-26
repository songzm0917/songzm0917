package com.songzm.rediscache.service.impl;

import com.songzm.rediscache.entity.User;
import com.songzm.rediscache.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getAll() throws Exception {
        log.info("---------getAll()--------");
        List<User> all = userService.getAll();
        log.info("---------getAll()--------"+all);
    }

    @Test
    public void findOneByUserId() throws Exception {
        log.info("---------findOneByUserId()--------");
        User user = userService.findOneByUserId(8L);
        log.info("---------findOneByUserId()--------"+user);
    }

    @Test
    public void add() throws Exception {

        User user = new User();
        user.setName("王五");
        user.setPassword("6666");
        user.setGradeId(1L);
        user.setLoginAddress("33333");
        log.info("---------add()--------"+user);
        user = userService.add(user);

        log.info("---------add()--------"+user.getId());
        User user1 = userService.findOneByUserId(user.getId());
        log.info("---------insert()--------"+user1);
    }




}