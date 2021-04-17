package cn.gdcp.service;

import cn.gdcp.domain.User;

import java.util.List;

public interface UserService {
    List<User> list();

    void save(User user, Long[] roles);

    void del(Long userId);
}
