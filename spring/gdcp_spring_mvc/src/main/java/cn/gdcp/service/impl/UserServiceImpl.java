package cn.gdcp.service.impl;

import cn.gdcp.dao.UserDao;
import cn.gdcp.service.UserService;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource(name ="userDao")
    private UserDao userDao;

//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }


   /* public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl(){}*/

    public void save() {

        userDao.save();

    }
}
