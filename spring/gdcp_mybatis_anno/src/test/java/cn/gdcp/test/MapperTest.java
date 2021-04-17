package cn.gdcp.test;

import cn.gdcp.domain.Order;
import cn.gdcp.domain.User;
import cn.gdcp.mapper.OrderMapper;
import cn.gdcp.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MapperTest {

    UserMapper userMapper;

    OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession(true);

        userMapper = sqlSession.getMapper(UserMapper.class);

        orderMapper = sqlSession.getMapper(OrderMapper.class);

    }

    @Test
    public void testSave(){
        User user = new User();
        user.setId(5);
        user.setUsername("lisi");
        user.setPassword("123");
        user.setBirthday("2020-11-05");

        userMapper.save(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4);
        user.setUsername("lisi");
        user.setPassword("123456");

        userMapper.update(user);
    }

    @Test
    public void testDel(){
        userMapper.delete(5);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(4);

        System.out.println(user);
    }

    @Test
    public void testFindAll(){
        List<User> userList = userMapper.findAll();

        for (User user :
                userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAndOrderAll(){
        List<User> userList = userMapper.findUserAndOrderAll();

        for (User user :
                userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testOrderFindAll(){
        List<Order> orderList = orderMapper.findAll();

        for (Order order
                :
                orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void testFindUserAndRoleAll(){
        List<User> userList = userMapper.findUserAndRoleAll();

        for (User user :
                userList) {
            System.out.println(user);
        }
    }

}
