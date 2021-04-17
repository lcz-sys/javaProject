package cn.gdcp.service;

import cn.gdcp.domain.Admin;

import java.util.List;

public interface AdminService {

    /*根据用户名和密码查询（管理员登录）*/
    Admin getByUsernameAndPassword(String username, String password);

    /*显示管理员*/
    List<Admin> findAllAdmins();

    /*添加管理员*/
    boolean addAdmin(Admin admin);

    /*删除管理员*/
    int deleteAdmin(int id);

    /*修改后台管理员信息*/
    boolean updateAdmin(Admin admin);

    /*id获取管理员信息*/
    Admin get(int id);

    /*搜索*/
    List<Admin> searchAdmins(String username, String start_time, String end_time);

    /*批量删除管理员*/
    int deleteSelectAdmin(int[] ids);
}
