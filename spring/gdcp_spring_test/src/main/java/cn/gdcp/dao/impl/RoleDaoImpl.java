package cn.gdcp.dao.impl;

import cn.gdcp.dao.RoleDao;
import cn.gdcp.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<Role> findAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role values (null,?,?)", role.getRoleName(), role.getRoleDesc());
    }

    public List<Role> findRoleByUserId(Long userId) {
        List<Role> roles = jdbcTemplate.query("SELECT * FROM sys_role r,sys_user_role ur WHERE r.id = ur.roleId AND ur.userId = ?", new BeanPropertyRowMapper<Role>(Role.class), userId);
        return roles;
    }
}
