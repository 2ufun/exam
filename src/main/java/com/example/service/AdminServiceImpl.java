package com.example.service;

import com.example.mapper.AdminMapper;
import com.example.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getAdmin(String id) {
        return adminMapper.getAdmin(id);
    }
}
