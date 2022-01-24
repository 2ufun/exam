package com.example.service;

import com.example.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(String id);

    void addUser(String name, Integer age, String detail);

    void updateUser(Integer id, String name, Integer age, String detail);

    void deleteUser(String id);
}
