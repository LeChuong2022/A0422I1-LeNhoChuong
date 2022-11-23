package codegym.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import codegym.vn.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/list")
    public String displayList(Model model){
        System.out.println("cucucucucucuc");
        model.addAttribute("students", studentService.findAll());
        System.out.println("changheee");

        return "student/list";
    }
}
