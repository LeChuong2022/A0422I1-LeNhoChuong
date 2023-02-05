package com.furamam04.controller;


import com.furamam04.entity.Contract;
import com.furamam04.service.*;
import com.furamam04.validate.ContractValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @GetMapping("")
    public String showContract(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "contract/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("services", serviceService.findAll());
        return "contract/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @Validated @ModelAttribute("contract") Contract contract,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        // check wa validate
        ContractValidate validate = new ContractValidate();
        validate.validate(contract, bindingResult);
        // check wa validate


        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("services", serviceService.findAll());
            return "contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "create new contract successful");
        return "redirect:/contract";
    }

    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("contract", contractService.findById(id));
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("services", serviceService.findAll());
        return "contract/edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @Validated @ModelAttribute("contract") Contract contract,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("employees", employeeService.findAll());
            model.addAttribute("customers", customerService.findAll());
            model.addAttribute("services", serviceService.findAll());
            return "contract/create";
        }
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "edit contract successful");
        return "redirect:/contract";
    }

    @GetMapping("detail/{id}")
    public String detailCustomer(Model model, @PathVariable("id") Long id) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/detail";
    }

    @GetMapping("delete/{id}")
    public String doDelete(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        contractDetailService.deleteAllByContract_Id(id);
        contractService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete successful");
        return "redirect:/contract";
    }


}
