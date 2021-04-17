package cn.gdcp.service.impl;

import cn.gdcp.dao.RoleDao;
import cn.gdcp.dao.UserDao;
import cn.gdcp.domain.Role;
import cn.gdcp.domain.User;
import cn.gdcp.service.UserService;

import javax.annotation.Resource;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Resource(name = "roleDao")
    private RoleDao roleDao;

    public List<User> list() {
        List<User> userList = userDao.findAll();

        for (User user : userList) {
            Long userId = user.getId();

            List<Role> roles = roleDao.findRoleByUserId(userId);

            user.setRoles(roles);
        }

        return userList;
    }

    public void save(User user, Long[] roles) {
        Long userId = userDao.save(user);
        userDao.SaveUserRoleRel(userId,roles);
    }

    public void del(Long userId) {
        userDao.delUser(userId);
        userDao.delUserRoleRel(userId);
    }

}
