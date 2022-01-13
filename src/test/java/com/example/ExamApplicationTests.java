package com.example;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class ExamApplicationTests {

	//DI注入数据源
	@Autowired
	UserMapper userMapper;

	@Test
	public void contextLoads() throws SQLException {
		for (User user : userMapper.getAllUser()) {
			System.out.println(user);
		}
		System.out.println(userMapper.getUserById("1"));
	}
}
