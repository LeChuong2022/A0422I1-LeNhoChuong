package blog.controller;

import blog.bean.Blog;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showBlog(Model model){
        model.addAttribute("blogs", blogService.findByAll());
        return "blog/index";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/create")
    public String doCreate(Model model, @ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        model.addAttribute("blog", new Blog());
        model.addAttribute("message", "Create new blog successful");
        return "blog/create";
    }

    @GetMapping("/delete/{id}")
    public String remove(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        String title = blogService.findById(id).getTitle();
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete " + title + " successful");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable("id")Long id){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/edit")
    public String doEdit(Model model, @ModelAttribute("blog")Blog blog){
        blogService.save(blog);
        model.addAttribute("blog",blog);
        model.addAttribute("message", "Edit successful");
        return "blog/edit";
    }
}
