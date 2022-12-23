package com.bookss09.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public String exception(NullPointerException ex){
        System.out.println("Lỗi NULL");
        String errorMsg = "lỗi Null";
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model){
        System.out.println("=========Error controller ==========");
        String errorMsg = ex.getMessage();
        model.addAttribute("errorMsg", errorMsg);
        return "error";
    }
}
