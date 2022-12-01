package product_management.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import product_management.bean.Product;
import product_management.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String displayList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "create")
    public String doCreate(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "create new product successful");
        return "redirect:/list";
    }

    @GetMapping("/update")
    public String showUpdate(Model model, @RequestParam("id") String id) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String doUpdate(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.edit(product);
        redirectAttributes.addFlashAttribute("mess", "Update successful");
        return "redirect:/list";
    }

    @RequestMapping("/remove")
    public String doRemove(@RequestParam("id") String id, RedirectAttributes redirectAttributes){
        String nameProductRemove = productService.findById(id).getName();
        productService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "Remove " + nameProductRemove + " successful");
        return "redirect:/list";
    }

    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }

    @RequestMapping("/search")
    public String search(@RequestParam("nameSearch") String nameSearch, Model model){
        model.addAttribute("products", productService.findByName(nameSearch));
        model.addAttribute("nameSearch",nameSearch);
        return "list";
    }

}
