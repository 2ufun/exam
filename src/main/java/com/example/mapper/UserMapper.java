package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getAllUser();
    User getUserById(String id);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
}
