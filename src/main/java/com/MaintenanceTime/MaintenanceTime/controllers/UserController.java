package com.MaintenanceTime.MaintenanceTime.controllers;

import com.MaintenanceTime.MaintenanceTime.models.User;
import com.MaintenanceTime.MaintenanceTime.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String viewLogin(Model model, User user){
        model.addAttribute("title", "Login");
        model.addAttribute("user", user);
        return "task/login";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String processUserInfo( Model model) {

        return "redirect:" + "task";
    }

}
