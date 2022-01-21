package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Admin;
import com.example.service.AdminServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {

        Admin target = adminService.getAdmin(id);

        if (target == null || !password.equals(target.getPassword())) {
            model.addAttribute("error", "用户或密码错误！");
            return "index";
        } else {
            System.out.println(target.getId());
            session.setAttribute("loginUser", target.getId());
            return "redirect:/all";
        }

    }
}
