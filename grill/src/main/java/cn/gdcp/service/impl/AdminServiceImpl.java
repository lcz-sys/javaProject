package cn.gdcp.service.impl;

import cn.gdcp.domain.Admin;
import cn.gdcp.mapper.AdminMapper;
import cn.gdcp.service.AdminService;
import cn.gdcp.utils.MD5Util;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin getByUsernameAndPassword(String username, String password) {

        String encode_pass = MD5Util.encode(password);

        Admin admin = adminMapper.getByUsernameAndPassword(username, encode_pass);

        return admin;

    }

    public List<Admin> findAllAdmins() {
        List<Admin> adminList = adminMapper.findAllAdmins();
        return adminList;
    }

    public boolean addAdmin(Admin admin) {
        if(adminMapper.getByUsername(admin.getUsername()) != null){
            return false;
        }
        admin.setPassword(MD5Util.encode(admin.getPassword()));
        boolean flag = adminMapper.addAdmin(admin);
        return flag;
    }

    public int deleteAdmin(int id) {
        int flag = adminMapper.deleteAdmin(id);
        return flag;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        admin.setPassword(MD5Util.encode(admin.getPassword()));
//        System.out.println(admin);
        boolean flag = adminMapper.updateAdmin(admin);
        return flag;
    }

    public Admin get(int id) {
        Admin admin = adminMapper.get(id);
        return admin;
    }

    @Override
    public List<Admin> searchAdmins(String username, String start_time, String end_time) {
        List<Admin> adminList = adminMapper.selectAdminByUsernameOrTime(username, start_time, end_time);
        return adminList;
    }

    @Override
    public int deleteSelectAdmin(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = adminMapper.deleteAdmin(id);
            count += num;
        }
        return count;
    }

}
