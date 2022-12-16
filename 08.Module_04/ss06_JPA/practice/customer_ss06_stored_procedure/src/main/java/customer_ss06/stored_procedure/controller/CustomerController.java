package customer_ss06.stored_procedure.controller;

import customer_ss06.stored_procedure.bean.Customer;
import customer_ss06.stored_procedure.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("create-customer")
    public String createForm (Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("create-customer")
    public String doCreate(Model model, @ModelAttribute("customer") Customer customer){
        customerService.insertCustomerWithStoredProcedure(customer);
        model.addAttribute("message", "create new customer successful");
        model.addAttribute("customer", customer);
        return "create";
    }
}
