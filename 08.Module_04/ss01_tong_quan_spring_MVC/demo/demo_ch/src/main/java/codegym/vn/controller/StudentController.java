package codegym.vn.controller;

import codegym.vn.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import codegym.vn.service.IStudentService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping("/list")
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        return "student/create";
    }

    @PostMapping("/create")
    public String create(Model model, @RequestParam("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("age") int age,
                         @RequestParam("address") String address, RedirectAttributes redirectAttributes) {
        studentService.createOrUpdate(new Student(id, name, age, address));
        redirectAttributes.addFlashAttribute("mess", "List was successful added.");
        return "redirect:/student/list";
    }

    @GetMapping("/edit")
    public String showFormUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("student", studentService.findById(id));
        return "student/edit";
    }

    @PostMapping("/edit")
    public String edit(Model model, @RequestParam("id") String id,
                       @RequestParam("name") String name,
                       @RequestParam("age") int age,
                       @RequestParam("address") String address,
                       RedirectAttributes redirectAttributes){
        studentService.createOrUpdate(new Student(id, name, age, address));
        redirectAttributes.addFlashAttribute("mess", "Edit successful");
        return "redirect:/student/list";
    }
}
