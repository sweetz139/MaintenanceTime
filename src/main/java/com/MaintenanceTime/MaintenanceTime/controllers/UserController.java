package com.MaintenanceTime.MaintenanceTime.controllers;

import com.MaintenanceTime.MaintenanceTime.models.UserDto;
import com.MaintenanceTime.MaintenanceTime.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.thymeleaf.util.Validate;

import javax.validation.Valid;

@Controller
@RequestMapping(value="user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String viewLogin(Model model, UserDto user){
        model.addAttribute("title", "Login");
        model.addAttribute("user", user);
        return "task/login";
    }

    @RequestMapping(value="", method = RequestMethod.POST)
    public String processUserInfo( Model model) {

        return "redirect:" + "task";
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "task/registration";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String processRegistrationForm(@ModelAttribute @Valid UserDto userDto,Model model, Errors error ){
        if(error.hasErrors()){
            return "redirect:" + "user/registration";
        }
        else{
            userDao.save(userDto);
            return "task/index";
        }
    }

}
