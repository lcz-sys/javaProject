package cn.gdcp.test;

import cn.gdcp.dao.UserMapper;
import cn.gdcp.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MapperTest {

    @Test
    public void test1() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();

//        user.setId(1);

//        user.setUsername("zhangsan");

//        user.setPassword("admin");

        List<User> userList = userMapper.findByCondition(user);

        System.out.println(userList);

    }

    @Test
    public void test2() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        List<User> userList = userMapper.findByIds(list);

        System.out.println(userList);
    }
}
