package customer.controller;

import customer.bean.Customer;
import customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("create-customer")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("create-customer")
    public String savaCustomer(Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "New customer created successfully");
        return "create";
    }

    @GetMapping("list-customer")
    public String displayList(Model model){
        model.addAttribute("list", customerService.findAll());
        return "list";
    }

    @GetMapping("edit-customer/{id}")
    public String editForm(Model model, @PathVariable("id") Long id){
        Customer customer = customerService.findById(id);
        if (customer != null){
            model.addAttribute("customer", customer);
            return "edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping("edit-customer")
    public String doEdit(Model model, @ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("message", "Update customer successful");
        return "edit";
    }

    @GetMapping("delete-customer/{id}")
    public String deleteForm(@PathVariable("id") Long id, Model model){
        Customer customer = customerService.findById(id);
        if (customer != null){
            model.addAttribute("customer", customer);
            return "delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping("delete-customer")
    public String doDelete(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:list-customer";
    }
}
