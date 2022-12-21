package com.example.blogexpanse.controller;

import com.example.blogexpanse.entity.Category;
import com.example.blogexpanse.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @GetMapping("list")
    public String showCategoryList(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/category-list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/category-create";
    }

    @PostMapping("create")
    public String doCreate(@ModelAttribute("category") Category category, Model model) {
        categoryService.save(category);
        model.addAttribute("message", "Create new category successful");
        return "category/category-create";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/category-edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @ModelAttribute("category") Category category) {
        categoryService.save(category);
        model.addAttribute("message", "Create new category successful");
        return "category/category-edit";
    }
    @GetMapping("delete/{id}")
    public String delete(Model model, @PathVariable("id")Long id, RedirectAttributes redirectAttributes){
        String categoryName = categoryService.findById(id).getCategoryName();
        categoryService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete " + categoryName + " category successful");
        return "redirect:/category/list";
    }

}
