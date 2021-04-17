package cn.gdcp.test;

import cn.gdcp.config.SpringConfiguration;
import cn.gdcp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJUnitTest {

    @Resource(name = "userService")
    private UserService userService;

//    @Autowired
    @Resource(name = "c3p0DataSource")
    private DataSource dataSource;

    @Test
    public void test() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
