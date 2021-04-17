package cn.gdcp.dao;

import cn.gdcp.domain.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public User findById(int id);

    public List<User> findByCondition(User user);

    public List<User> findByIds(List<Integer> ids);
}
