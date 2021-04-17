package cn.gdcp.test;

import cn.gdcp.domain.Admin;
import cn.gdcp.mapper.AdminMapper;
import cn.gdcp.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void addAdmin(){


        for (int i = 1; i < 100; i++) {
            Admin admin = new Admin();

            admin.setPassword(MD5Util.encode("admin"));
            admin.setEmail("111@qq.com");
            admin.setPhone("12345678901");
            admin.setUsername("admin"+i);
            admin.setCreate_time(new Date());
            adminMapper.addAdmin(admin);
        }

    }

    @Test
    public void editAdmin(){
        Admin admin = new Admin();

        admin.setPassword(MD5Util.encode("admin"));
        admin.setCreate_time(new Date());
        admin.setUsername("admin");
        admin.setEmail("123@qq.com");
        admin.setPhone("12345678901");

        boolean b = adminMapper.updateAdmin(admin);

        System.out.println(b);
    }

}
