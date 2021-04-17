package cn.gdcp.service;

import cn.gdcp.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService  {

    /*显示用户*/
    List<User> findAllUsers();

    /*添加用户*/
    boolean addUser(User user);

    /*删除用户*/
    int deleteUser(int id);

    /*修改后台用户信息*/
    boolean updateUser(User user);

    /*id获取用户信息*/
    User get(int id);

    /*搜索*/
    List<User> searchUsers(String username, String start_time, String end_time);

    /*批量删除用户*/
    int deleteSelectUser(int[] ids);

    /*修改用户密码*/
    boolean editPass(int id,String password,String oldPass);

    /*验证用户名*/
    User getByUsername(String username);

    /*用户登录*/
    boolean getByUsernameAndPassword(String username, String password);

    /*修改收货地址*/
    boolean updateAddress(int id, String name, String phone, String address);

}
