package cn.gdcp.factory;

import cn.gdcp.dao.UserDao;
import cn.gdcp.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
