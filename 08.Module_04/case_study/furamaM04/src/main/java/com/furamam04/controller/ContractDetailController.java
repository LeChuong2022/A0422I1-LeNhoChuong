package com.furamam04.controller;

import com.furamam04.entity.Contract;
import com.furamam04.entity.ContractDetail;
import com.furamam04.service.IAttachServiceService;
import com.furamam04.service.IContractDetailService;
import com.furamam04.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractService contractService;

    @GetMapping("")
    public String showContractDetail(Model model) {
        model.addAttribute("contractDetails", contractDetailService.findAll());
        return "contract-detail/list";
    }

    @GetMapping("create")
    public String createForm(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findAll());
        return "contract-detail/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @Validated @ModelAttribute("contractDetail") ContractDetail contractDetail,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contracts", contractService.findAll());
            model.addAttribute("attachServices", attachServiceService.findAll());
            return "contract-detail/create";
        }
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "create new contract detail successful");
        return "redirect:/contractDetail";
    }

    //
    @GetMapping("edit/{id}")
    public String editForm(Model model, @PathVariable("id") Long id) {
        model.addAttribute("contractDetail", contractDetailService.findById(id));
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("attachServices", attachServiceService.findAll());
        return "contract-detail/edit";
    }

    @PostMapping("edit")
    public String doEdit(Model model, @Validated @ModelAttribute("contractDetail") ContractDetail contractDetail,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("message", "edit contract detail successful");
        return "redirect:/contractDetail";
    }

    @GetMapping("detail/{id}")
    public String detailCustomer(Model model, @PathVariable("id") Long id) {
        model.addAttribute("contractDetail", contractDetailService.findById(id));
        return "contract-detail/detail";
    }

    @GetMapping("delete/{id}")
    public String doDelete(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        contractDetailService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete successful");
        return "redirect:/contractDetail";
    }

    @GetMapping("delete-contract-side/{id}")
    public String doDeleteContractSide(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Long idContract = contractDetailService.findById(id).getContract().getId();
        contractDetailService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete successful");
        return "redirect:/contract/edit/" + idContract;
    }

}
