package com.codegym.controller;

import com.codegym.bean.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/showForm")
    public String showFormCreate(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/addEmployee")
    public String create(@ModelAttribute("employee")Employee temp,
                         ModelMap model){
        model.addAttribute("name", temp.getName());
        model.addAttribute("contactNumber", temp.getContactNumber());
        model.addAttribute("id", temp.getId());
        return "employee/info";
    }

}
