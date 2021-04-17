package cn.gdcp.test;

import cn.gdcp.domain.User;
import cn.gdcp.mapper.UserMapper;
import cn.gdcp.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void AddUsers(){
        for (int i = 1; i < 1000; i++) {
            User user = new User();
            user.setPassword(MD5Util.encode("123456"));
            user.setName("张三"+i);
            user.setPhone("17645678901");
            user.setUsername("user"+i);
            user.setCreate_time(new Date());
            user.setAddress("广州市天河区元岗街道天源路789号");
            userMapper.addUser(user);
        }

    }
}
