package cn.gdcp.dao.impl;

import cn.gdcp.dao.UserDao;
import cn.gdcp.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    public UserDaoImpl(){
        System.out.println("UserDaoImpl创建...");
    }

    public void init(){
        System.out.println("初始化...");
    }

    public void destroy(){
        System.out.println("销毁...");
    }*/

    public void save() {

/*
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
*/

//        System.out.println(username+"---->"+age);

        System.out.println("save running...");
    }
}
