package cn.gdcp.service;

import cn.gdcp.domain.Role;

import java.util.List;

public interface
RoleService {

    List<Role> list();

    void save(Role role);
}
