package cn.gdcp.test;

import cn.gdcp.dao.UserDao;
import cn.gdcp.service.UserService;
import cn.gdcp.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void save() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao1 = (UserDao) context.getBean("userDao");
        UserDao userDao2 = (UserDao) context.getBean("userDao");

//        userDao1.save();

        System.out.println(userDao1);
        System.out.println(userDao2);


    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDao userDao = (UserDao) context.getBean("userDao");

        System.out.println(userDao);

//        context.close();


    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");

        userService.save();
    }

}
