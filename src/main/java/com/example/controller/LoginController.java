package com.example.controller;

import com.example.pojo.Admin;
import com.example.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AdminServiceImpl adminService;

    @RequestMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
        Admin target = adminService.getAdmin(id, password);
        if (target == null) {
            model.addAttribute("error", "用户或密码错误！");
            return "index";
        } else {
            session.setAttribute("loginUser", target.getId());
            return "redirect:/all";
        }
    }

    @RequestMapping("/admin")
    public String admin(Model model, HttpSession session) {
        String id = (String) session.getAttribute("loginUser");
        model.addAttribute("id", id);
        return "admin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
