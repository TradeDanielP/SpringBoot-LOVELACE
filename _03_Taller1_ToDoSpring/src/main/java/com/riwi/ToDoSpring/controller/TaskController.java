package com.riwi.ToDoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.ToDoSpring.entity.Task;
import com.riwi.ToDoSpring.service.TaskService;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskService objTaskService;

    @GetMapping()
    public String showViewTask(
        Model objModel,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size) {

        Page<Task> listTasks = this.objTaskService.findAllPaginate(page - 1,size);

        objModel.addAttribute("TaskList", listTasks);
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listTasks.getTotalPages());

        return "viewTask";
    }

    @GetMapping("/form")
    public String showViewForm(Model model) {

        model.addAttribute("task", new Task());
        model.addAttribute("action", "/create-task");

        return "viewForm";
    }

    @PostMapping("create-task")
    public String createTask(@ModelAttribute Task objTask) {
        this.objTaskService.create(objTask);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        this.objTaskService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, Model model) {
        Task objTask = this.objTaskService.findTaskById(id);

        model.addAttribute("task", objTask);
        model.addAttribute("action", "/edit/" + id);

        return "viewForm";
    }

    @PostMapping("edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task objTask){
        this.objTaskService.updateTask(id, objTask);

        return "redirect:/";
    }

}
