package cn.gdcp.test;

import cn.gdcp.config.SpringConfiguration;
import cn.gdcp.service.UserService;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    public void test() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///db1");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }

    @Test
    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///db1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    public void test3() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");

        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        DruidPooledConnection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();

    }

    @Test
    public void test4() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");

        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();

    }

    @Test
    public void test5() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ComboPooledDataSource c3p0DataSource = (ComboPooledDataSource) context.getBean("c3p0DataSource");

        Connection conn = c3p0DataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }

    @Test
    public void test6() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DruidDataSource druidDataSource = (DruidDataSource) context.getBean("druidDataSource");

        DruidPooledConnection conn = druidDataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }

    @Test
    public void test7(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        UserService userService = (UserService) context.getBean("userService");

        userService.save();
    }
}
