package com.example.service;

import com.example.pojo.Admin;

public interface AdminService {
    Admin getAdmin(String id, String password);
}
