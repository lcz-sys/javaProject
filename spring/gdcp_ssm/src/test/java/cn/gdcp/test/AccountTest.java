package cn.gdcp.test;

import cn.gdcp.domain.Account;
import cn.gdcp.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void test(){
        List<Account> list = accountMapper.findAll();

        System.out.println(list);
    }
}
