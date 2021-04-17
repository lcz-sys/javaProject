package cn.gdcp.mapper;

import cn.gdcp.domain.User;

import java.util.List;

public interface UserMapper {

    public void save(User user);

    public User findById(int id);

    public List<User> findAll();

    public List<User> findUserAndRoleAll();
}
