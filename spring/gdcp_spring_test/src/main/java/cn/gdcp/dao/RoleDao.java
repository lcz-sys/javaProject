package cn.gdcp.dao;

import cn.gdcp.domain.Role;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long userId);
}
