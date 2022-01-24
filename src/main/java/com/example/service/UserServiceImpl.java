package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void addUser(String name, Integer age, String detail) {
        userMapper.addUser(name, age, detail);
    }

    @Override
    public void updateUser(Integer id, String name, Integer age, String detail) {
        userMapper.updateUser(id, name, age, detail);
    }

    @Override
    public void deleteUser(String id) {
        userMapper.deleteUser(id);
    }
}
