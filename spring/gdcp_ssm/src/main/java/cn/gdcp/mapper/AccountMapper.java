package cn.gdcp.mapper;

import cn.gdcp.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();

}
