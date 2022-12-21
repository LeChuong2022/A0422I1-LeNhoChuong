package com.example.blogexpanse.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
//    @ExceptionHandler(Exception.class)
//    public String exception(Exception ex){
//        System.out.println("Lỗi mới nè: " + ex.getMessage());
//        return "blog/error";
//    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String exception(IllegalArgumentException ex){
        System.out.println("Lỗi mới nè: " + ex.getMessage());
        return "blog/error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String exception2(Exception ex){
        System.out.println("Lỗi mới nè error2: " + ex.getMessage());
        return "blog/error2";
    }


}
