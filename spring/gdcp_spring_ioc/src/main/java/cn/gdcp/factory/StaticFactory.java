package cn.gdcp.factory;

import cn.gdcp.dao.UserDao;
import cn.gdcp.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
