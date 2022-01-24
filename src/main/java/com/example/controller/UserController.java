package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String allUser(Model model) {
        model.addAttribute("list", userService.getAllUser());
        return "allUser";
    }

    @GetMapping("/all/{id}")
    public String queryUser(Model model, @PathVariable String id) {

        User user = userService.getUserById(id);

        if (user == null) {
            model.addAttribute("error", "未查找到此用户！");
        } else {
            List<User> list = new ArrayList<>();
            list.add(user);
            model.addAttribute("list", list);
        }

        return "allUser";
    }

    @GetMapping("/add")
    public String addUser() {
        return "addUser";
    }

    @PostMapping("/add")
    @ResponseBody
    public void addUser(HttpServletRequest request) {
        userService.addUser(request.getParameter("name"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("detail"));
    }

    @GetMapping("/update/{id}")
    public String toUpdateUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/update")
    @ResponseBody
    public void updateUser(HttpServletRequest request) {
        userService.updateUser(Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("detail"));
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/all";
    }
}
