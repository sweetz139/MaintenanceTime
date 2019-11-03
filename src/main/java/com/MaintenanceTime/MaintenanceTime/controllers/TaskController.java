package com.MaintenanceTime.MaintenanceTime.controllers;

import com.MaintenanceTime.MaintenanceTime.models.Task;
import com.MaintenanceTime.MaintenanceTime.models.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value ="task")
public class TaskController {

    @Autowired
    private TaskDao taskDao;

    @RequestMapping(value ="")
    public String index(Model model){
        model.addAttribute("tasks", taskDao.findAll());
        model.addAttribute("title","Tasks");
        return "task/index";
    }

    @RequestMapping(value="add", method=RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add a Task");
        model.addAttribute(new Task());
        return "task/add";
    }

    @RequestMapping(value="add",method=RequestMethod.POST)
    public String processAddTaskForm(@ModelAttribute @Valid Task newTask, Errors error, Model model){
        if(error.hasErrors()){
            model.addAttribute("title", "Add Task");
            return "task/add";
        }
        taskDao.save(newTask);
        model.addAttribute("title","Add a Task");
        return "redirect:";
    }

    @RequestMapping(value="remove",method=RequestMethod.GET)
    public String displayRemoveForm(Model model){
        model.addAttribute("title","Remove Tasks");
        model.addAttribute("tasks", taskDao.findAll());
        return "task/remove";
    }

    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveForm(@RequestParam int[] taskIds){
        for(int taskId : taskIds){

            taskDao.deleteById(taskId);

        }
        return "redirect:";

    }
}


