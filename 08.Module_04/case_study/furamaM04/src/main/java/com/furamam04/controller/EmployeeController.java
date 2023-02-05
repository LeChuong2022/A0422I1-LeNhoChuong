package com.furamam04.controller;

import com.furamam04.entity.*;
import com.furamam04.service.*;
import com.furamam04.validate.EmployeeValidate;
import com.furamam04.validate.ServiceValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public String showEmployeeWithPagingAndSort(Model model,
                                                @RequestParam("page") Optional<Integer> page,
                                                @RequestParam("size") Optional<Integer> size,
                                                @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Page<Employee> employees;

        employees = employeeService.findAllWithPagingAndSort(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));

        model.addAttribute("employees", employees);
        int totalPages = employees.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        List<Account> accounts = accountService.findAll();
        model.addAttribute("pageCount", currentPage); // để hiển thị số thứ tự
        model.addAttribute("sizeCount", pageSize); // để hiển thị số thứ tự
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/list";
    }

    @GetMapping("search")
    public String showEmployeeWithPagingAndSortAndSearch(Model model,
                                                         @RequestParam("page") Optional<Integer> page,
                                                         @RequestParam("size") Optional<Integer> size,
                                                         @RequestParam("sort") Optional<String> sort,
                                                         @RequestParam("search") Optional<String> search) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Page<Employee> employees;
        if (search.isPresent()) {
            employees = employeeService.findAllByNameContainingOrIdCardContainingOrPhoneContaining(search.get(), PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        } else {
            employees = employeeService.findAllWithPagingAndSort(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        }
        model.addAttribute("employees", employees);
        int totalPages = employees.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        List<Account> accounts = accountService.findAll();
        model.addAttribute("pageCount", currentPage); // để hiển thị số thứ tự
        model.addAttribute("sizeCount", pageSize); // để hiển thị số thứ tự
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/list";
    }

    //
    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("account", new Account());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @Validated @ModelAttribute("employee") Employee employee,
//                           @Validated @ModelAttribute("account") Account account,
                           BindingResult bindingResult) {
        //        Check nguyên dương
//        EmployeeValidate validate = new EmployeeValidate();
//        validate.validate(employee, bindingResult);
//        CHeck nguyên dương
        // không sài account do validate bị lỗi
        if (bindingResult.hasErrors()) {
//            model.addAttribute("account", account);
            model.addAttribute("positions", positionService.findAll());
            model.addAttribute("educationDegrees", educationDegreeService.findAll());
            model.addAttribute("divisions", divisionService.findAll());
            return "employee/create";
        }
//        employee.setAccount(account);
        employeeService.save(employee);
        model.addAttribute("employee", new Employee());
//        model.addAttribute("account", new Account());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("message", "create new employee successful");
        return "employee/create";
    }

    @GetMapping("delete/{id}")
    public String doDelete(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        String employeeCustomer = employeeService.findById(id).getName();
        employeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer: " + employeeCustomer + " successful");
        return "redirect:/employee";
    }

    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("employee", employeeService.findById(id));
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        return "employee/edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        model.addAttribute("employee", employee);
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("accounts", accountService.findAll());
        model.addAttribute("message", "edit customer successful");
        return "employee/edit";
    }
}
