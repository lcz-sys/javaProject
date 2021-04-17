package cn.gdcp.test;

import cn.gdcp.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
//@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTempTest {

  /*  @Resource(name = "druidDataSource")
    private DataSource dataSource;*/

  @Resource(name = "jdbcTemplate")
  private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        /*DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db1");
        dataSource.setUsername("root");
        dataSource.setPassword("root");*/

        /*JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);*/


        String sql = "insert into account values(null,?,?)";

        int count = jdbcTemplate.update(sql, "Amy", 50000);

        if (count > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }
}
