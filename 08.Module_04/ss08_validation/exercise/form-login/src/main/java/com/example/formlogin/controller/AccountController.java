package com.example.formlogin.controller;

import com.example.formlogin.entity.Account;
import com.example.formlogin.service.IAccountService;
import com.example.formlogin.validate.AccountValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("accounts", accountService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("account", new Account());
        return "create";
    }

    @PostMapping("/create")
    public String create(Model model, @Valid @ModelAttribute("account") Account account,
                         BindingResult bindingResult) {
        AccountValidate validate = new AccountValidate();
        validate.validate(account, bindingResult);
        if (bindingResult.hasErrors()) {
            List<Account> accounts = accountService.findAll();
            model.addAttribute("accounts", accounts);
            return "/create";
        }
        accountService.save(account);
        return "redirect:/";
    }
}
