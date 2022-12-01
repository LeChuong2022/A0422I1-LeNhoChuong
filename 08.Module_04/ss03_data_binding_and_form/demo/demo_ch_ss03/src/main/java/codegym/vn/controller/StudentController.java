package codegym.vn.controller;

import codegym.vn.bean.Student;
import codegym.vn.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

//    Cach 1:
//    @GetMapping("/list")
    @RequestMapping(method = RequestMethod.GET, value = {"/list"})
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student/list";
    }
    /* Cach 1
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        return "create_before";
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
     */
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student", new Student());
        return "student/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("student")Student temp,
                         RedirectAttributes redirectAttributes){
        studentService.createOrUpdate(temp);
        redirectAttributes.addFlashAttribute("mess", "Create a new student successful");
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

    @GetMapping("/search")
    public String search(Model model, @RequestParam("searchName") String searchName){
        model.addAttribute("students", studentService.findByName(searchName));
        model.addAttribute("searchName", searchName);
        return "student/list";
    }
    @GetMapping("/{id:[1-3]}/detail")
    public String showDetail(@PathVariable int id, Model model){
        System.out.println("Lấy thông tin của ID: " + id);
        model.addAttribute("studentId", id);
        return "/student/detail";
    }

}
