package com.bookss09.controller;

import com.bookss09.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("list")
    public String bookList(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book/list";
    }
}
