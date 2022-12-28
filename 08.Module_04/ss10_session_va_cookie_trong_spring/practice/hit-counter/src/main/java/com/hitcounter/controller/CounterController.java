package com.hitcounter.controller;


import com.hitcounter.model.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CounterController {
    @Autowired
    HttpSession httpSession;


    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter, Model model) {
        if (httpSession.getAttribute("counter") != null) {
            counter = (Counter) httpSession.getAttribute("counter");
        }
        counter.increment();
        httpSession.setAttribute("counter", counter);
        model.addAttribute("counter", counter);
        return "/index";
    }

}
