package cn.gdcp.service.impl;

import cn.gdcp.dao.RoleDao;
import cn.gdcp.domain.Role;
import cn.gdcp.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    public List<Role> list() {
        return roleDao.findAll();
    }

    public void save(Role role) {
        roleDao.save(role);
    }

}
