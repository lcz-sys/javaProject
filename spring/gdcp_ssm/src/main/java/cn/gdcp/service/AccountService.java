package cn.gdcp.service;

import cn.gdcp.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void save(Account account);

}
