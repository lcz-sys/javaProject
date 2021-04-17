package cn.gdcp.dao;

import cn.gdcp.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    Long save(User user);

    void SaveUserRoleRel(Long id, Long[] roles);

    void delUser(Long userId);

    void delUserRoleRel(Long userId);
}
