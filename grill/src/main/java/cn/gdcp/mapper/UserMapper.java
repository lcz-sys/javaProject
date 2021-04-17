package cn.gdcp.mapper;

import cn.gdcp.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /*显示用户*/
    List<User> findAllUsers();

    /*根据用户名或时间查询用户*/
    List<User> selectUserByUsernameOrTime(@Param("username") String username, @Param("start_time") String start_time, @Param("end_time") String end_time);

    /*添加用户*/
    boolean addUser(User user);

    /*删除用户*/
    int deleteUser(@Param("id") int id);

    /*修改后台用户信息*/
    boolean updateUser(User user);

    /*id获取用户信息*/
    User get(int id);

    /*username获取用户信息（验证）*/
    User findUserByUsername(@Param("username") String username);

    /*手机号查询用户*/
    User findUserByPhone(@Param("phone") String phone);

    /*修改用户密码*/
    boolean updatePass(User user);

    /*查询用户密码*/
    String selectPass(@Param("id") int id);

    /*修改收货地址*/
    boolean updateAddress(@Param("id") int id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);
}
