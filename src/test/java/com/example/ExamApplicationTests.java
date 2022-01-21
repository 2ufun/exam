package com.example;

import com.example.mapper.AdminMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Admin;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
class ExamApplicationTests {

	//DI注入数据源
	@Autowired
	AdminMapper adminMapper;

	@Test
	public void contextLoads() throws SQLException {
		System.out.println(adminMapper.getAdmin("root", "123456"));
	}
}
