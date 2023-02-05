package com.furamam04.controller;

import com.furamam04.entity.Customer;
import com.furamam04.entity.CustomerType;
import com.furamam04.service.IContractService;
import com.furamam04.service.ICustomerService;
import com.furamam04.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showCustomerWithPagingAndSort(Model model,
                                                @RequestParam("page") Optional<Integer> page,
                                                @RequestParam("size") Optional<Integer> size,
                                                @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Page<Customer> customers;

        customers = customerService.findAllWithPagingAndSort(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));

        model.addAttribute("customers", customers);
        int totalPages = customers.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("pageCount", currentPage); // để hiển thị số thứ tự
        model.addAttribute("sizeCount", pageSize); // để hiển thị số thứ tự
        model.addAttribute("customerTypes", customerTypes);
        return "customer/list";
    }

    @GetMapping("search")
    public String showCustomerWithPagingAndSortAndSearch(Model model,
                                                         @RequestParam("page") Optional<Integer> page,
                                                         @RequestParam("size") Optional<Integer> size,
                                                         @RequestParam("sort") Optional<String> sort,
                                                         @RequestParam("search") Optional<String> search) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Page<Customer> customers;

        // search chỉ khác chỗ này - start
        if (search.isPresent()) {
            customers = customerService.findAllWithPagingAndSortAndSearch(search.get(), PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        } else {
            customers = customerService.findAllWithPagingAndSort(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        }
        // search chỉ khác chỗ này - end
        model.addAttribute("customers", customers);
        int totalPages = customers.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("pageCount", currentPage); // để hiển thị số thứ tự
        model.addAttribute("sizeCount", pageSize); // để hiển thị số thứ tự
        model.addAttribute("customerTypes", customerTypes);
        return "customer/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @Validated @ModelAttribute("customer") Customer customer,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        }
        customerService.save(customer);
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("message", "create new customer successful");
        return "customer/create";
    }

    @GetMapping("delete/{id}")
    public String doDelete(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        String nameCustomer = customerService.findById(id).getName();
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer: " + nameCustomer + " successful");
        return "redirect:/customer";
    }

    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("message", "edit customer successful");
        return "customer/edit";
    }

    //    Khách hàng có hợp đồng
    @GetMapping("customerContract")
    public String showCustomerContractWithPagingAndSortAndSearch(Model model,
                                                                 @RequestParam("page") Optional<Integer> page,
                                                                 @RequestParam("size") Optional<Integer> size,
                                                                 @RequestParam("sort") Optional<String> sort,
                                                                 @RequestParam("search") Optional<String> search) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Page<Customer> customers;

        // search chỉ khác chỗ này - start
        if (search.isPresent()) {
            customers = customerService.findAllJoinContractWithSearch(search.get(), PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        } else {
            customers = customerService.findAllJoinContract(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).ascending()));
        }
        // search chỉ khác chỗ này - end
        model.addAttribute("customers", customers);
        int totalPages = customers.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        List<CustomerType> customerTypes = customerTypeService.findAll();
        model.addAttribute("pageCount", currentPage); // để hiển thị số thứ tự
        model.addAttribute("sizeCount", pageSize); // để hiển thị số thứ tự
        model.addAttribute("customerTypes", customerTypes);
        return "customer/listWithContract";
    }

    @GetMapping("detail/{id}")
    public String detailCustomer(Model model, @PathVariable("id") Long id) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/detail";
    }

    @GetMapping("calTotalMoney")
    public String calTotalMoney(Model model) {
        model.addAttribute("calTotalMoneys", customerService.calTotal());
        return "customer/listTotalMoney";
    }

}
