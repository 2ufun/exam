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

    void addUser(String name, Integer age, String detail);

    void updateUser(Integer id, String name, Integer age, String detail);

    void deleteUser(String id);
}
