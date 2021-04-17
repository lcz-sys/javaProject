package cn.gdcp.test;

import cn.gdcp.domain.Order;
import cn.gdcp.domain.User;
import cn.gdcp.mapper.OrderMapper;
import cn.gdcp.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

        user.setUsername("xiaoming");

        user.setPassword("admin");

        user.setBirthday(new Date());

        userMapper.save(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findById(9);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd E HH:mm:ss");

        String date = simpleDateFormat.format(user.getBirthday());

        System.out.println(date);

        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        PageHelper.startPage(5,3);

        List<User> userList = userMapper.findAll();

        for (User user :
                userList) {
            System.out.println(user);
        }

        PageInfo<User> pageInfo = new PageInfo<User>(userList);

        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(pageInfo.isIsFirstPage());
        System.out.println(pageInfo.isIsLastPage());
        System.out.println(pageInfo.getPrePage());
        System.out.println(pageInfo.getNextPage());

        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.findAll();

        for (Order order :
                orderList) {
            System.out.println(order);
        }

        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();

        for (User user :
                userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserAndRoleAll();

        for (User user :
                userList) {
            System.out.println(user);
        }
    }
}
