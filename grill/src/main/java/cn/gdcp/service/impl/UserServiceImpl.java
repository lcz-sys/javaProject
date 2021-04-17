package cn.gdcp.service.impl;

import cn.gdcp.domain.User;
import cn.gdcp.mapper.UserMapper;
import cn.gdcp.service.UserService;
import cn.gdcp.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        List<User> userList = userMapper.findAllUsers();
        return userList;
    }

    @Override
    public boolean addUser(User user) {
        if (userMapper.findUserByPhone(user.getPhone()) != null) {
            return false;
        }
        user.setPassword(MD5Util.encode(user.getPassword()));
        boolean flag = userMapper.addUser(user);
        return flag;
    }

    @Override
    public int deleteUser(int id) {
        int flag = userMapper.deleteUser(id);
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        if (user.getPassword() != null) {
            user.setPassword(MD5Util.encode(user.getPassword()));
        }
//        System.out.println(user);
        boolean flag = userMapper.updateUser(user);
        return flag;
    }

    @Override
    public User get(int id) {
        User user = userMapper.get(id);
        return user;
    }

    @Override
    public List<User> searchUsers(String username, String start_time, String end_time) {
        List<User> userList = userMapper.selectUserByUsernameOrTime(username, start_time, end_time);
        return userList;
    }

    @Override
    public int deleteSelectUser(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = userMapper.deleteUser(id);
            count += num;
        }
        return count;
    }

    @Override
    public boolean editPass(int id, String password, String oldPass) {
        String pass = userMapper.selectPass(id);
        String encode = MD5Util.encode(oldPass);
        if (!pass.equals(encode)) {
            return false;
        }
        User user2 = new User();
        user2.setPassword(MD5Util.encode(password));
        user2.setId(id);
        boolean flag = userMapper.updatePass(user2);
        return flag;
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public boolean getByUsernameAndPassword(String username, String password) {
        User user = userMapper.findUserByUsername(username);
        if(user == null){
            return false;
        }
        if(!user.getPassword().equals(MD5Util.encode(password))){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAddress(int id, String name, String phone, String address) {
        return userMapper.updateAddress(id,name,phone,address);
    }
}
