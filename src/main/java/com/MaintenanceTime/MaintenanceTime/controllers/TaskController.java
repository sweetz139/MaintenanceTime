package com.MaintenanceTime.MaintenanceTime.controllers;

import com.MaintenanceTime.MaintenanceTime.models.Task;
import com.MaintenanceTime.MaintenanceTime.models.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.Errors;

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

        return "task/view";
    }

    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewTask(Model model,@PathVariable("id")int id){
        Task task = taskDao.getOne(id);
        model.addAttribute("task",task);
        return "task/view";
    }

}


