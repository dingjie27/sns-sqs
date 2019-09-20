package com.aws.service.impl;

import com.aws.po.User;
import com.aws.service.UserService;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Resource
    private RedisServiceImpl redisService;

    /**
     * 获取User逻辑：如缓存存在则从换从取值，否则从DB中获取，插入缓存
     */

    public List<User> showAll() {

        return userDao.showAll();
    }



    public List<User> selectByName(String name){
        return userDao.selectByName(name);
    }


    public User selectByID(String id) {

        User user=userDao.selectByID(id);

        return user;
    }



    public void addUser(User user){
        userDao.addUser(user);


    }

    public void updateByUserID(User user) {

        userDao.updateByUserID(user);
    }


    public void deleteByUserID(String id) {

        userDao.deleteByUserID(id);

    }

}
