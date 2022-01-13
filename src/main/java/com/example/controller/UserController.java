package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    public String allUser(Model model) {
        model.addAttribute("list", userMapper.getAllUser());
        return "allUser";
    }

    @RequestMapping("/all/{id}")
    public String queryUser(Model model, @PathVariable String id) {
        List<User> list = new ArrayList<>();
        list.add(userMapper.getUserById(id));
        model.addAttribute("list", list);
        return "allUser";
    }

    @RequestMapping("/add")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/add/{id}/{name}/{age}/{detail}")
    public String addUser(@PathVariable String id, @PathVariable String name,
                          @PathVariable Integer age, @PathVariable String detail) {
        userMapper.addUser(new User(id, name, age, detail));
        return "redirect:/all";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdateUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userMapper.getUserById(id));
        return "updateUser";
    }

    @RequestMapping("/update/{id}/{name}/{age}/{detail}")
    public String updateUser(@PathVariable String id, @PathVariable String name,
                             @PathVariable Integer age, @PathVariable String detail) {
        userMapper.updateUser(new User(id,name,age,detail));
        return "redirect:/all";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userMapper.deleteUser(id);
        return "redirect:/all";
    }
}
