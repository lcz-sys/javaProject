package cn.gdcp.test;

import cn.gdcp.config.SpringConfig;
import cn.gdcp.domain.Account;
import com.alibaba.druid.pool.DruidPooledResultSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfig.class})
public class JdbcTemplateCRUDTest {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        String sql = "update account set balance = balance + 50000 where id = ?";

        int count = jdbcTemplate.update(sql, 6);

        if(count>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

    @Test
    public void test2(){
        String sql = "delete from account where balance < ?";

        int count = jdbcTemplate.update(sql, 5000);

        if(count>0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
    }

    @Test
    public void test3(){
        String sql = "insert into account values(null,?,?)";

        int count = jdbcTemplate.update(sql, "libai",10000000);

        if(count>0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
    }

    @Test
    public void test4(){
        String sql = "select * from account";

        List<Account> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Account>(Account.class));

        for(Account account:list){
            System.out.println(account);
        }

    }

    @Test
    public void test5(){
        String sql = "select * from account where id = ?";

        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), 16);

        System.out.println(account);
    }

    @Test
    public void test6(){
        String sql = "select count(*) from account";

        Long count = jdbcTemplate.queryForObject(sql, Long.class);

        System.out.println(count);
    }


}
