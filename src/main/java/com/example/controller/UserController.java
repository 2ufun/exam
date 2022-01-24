package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public String allUser(Model model) {
        model.addAttribute("list", userService.getAllUser());
        return "allUser";
    }

    @RequestMapping("/all/{id}")
    public String queryUser(Model model, @PathVariable String id) {

        User user = userService.getUserById(id);

        if(user == null) {
            model.addAttribute("err", "error! no such user");
        } else {
            List<User> list = new ArrayList<>();
            list.add(user);
            model.addAttribute("list", list);
        }
        return "allUser";
    }

    @RequestMapping("/toAdd")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addUser(HttpServletRequest request) {
        userService.addUser(request.getParameter("name"),
                            Integer.parseInt(request.getParameter("age")),
                            request.getParameter("detail"));
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdateUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }

    @RequestMapping("/update")
    @ResponseBody
    public void updateUser(HttpServletRequest request) {
        userService.updateUser(Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("detail"));
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return "redirect:/all";
    }

    @RequestMapping("/demo")
    public String demo(){
        return "demo";
    }
}
