package cn.gdcp.mapper;

import cn.gdcp.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    /*根据用户名和密码查询（管理员登录）*/
    Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /*显示管理员*/
    List<Admin> findAllAdmins();

    /*根据用户名查询管理员*/
    List<Admin> selectAdminByUsernameOrTime(@Param("username") String username, @Param("start_time") String start_time, @Param("end_time") String end_time);

    /*添加管理员*/
    boolean addAdmin(Admin admin);

    /*删除管理员*/
    int deleteAdmin(@Param("id") int id);

    /*修改后台管理员信息*/
    boolean updateAdmin(Admin admin);

    /*id获取管理员信息*/
    Admin get(int id);

    /*查询管理员名是否重复*/
    Admin getByUsername(@Param("username") String username);

}
