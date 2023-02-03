package com.furamam04.controller;

import com.furamam04.entity.Service;
import com.furamam04.service.IRentTypeService;
import com.furamam04.service.IServiceService;
import com.furamam04.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public String showServiceList(Model model) {
        model.addAttribute("services", serviceService.findAll());
        return "service/list";
    }

    @GetMapping("create")
    public String createForm(Model model, @ModelAttribute("service") Service service) {
        if (service.getServiceType() == null){
            service.setServiceType(serviceTypeService.findById(1L));
        }
        Service service1 = new Service();
        service1.setServiceType(service.getServiceType());
        model.addAttribute("service", service1);
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        if (service1.getServiceType().getName().equals("House"))
            return "service/house/create";
        else if (service1.getServiceType().getName().equals("Room"))
            return "service/room/create";
        else
        return "service/villa/create";
    }

    @PostMapping("create")
    public String doCreate(Model model, @ModelAttribute("service") Service service) {
        serviceService.save(service);
        model.addAttribute("service", new Service());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        model.addAttribute("message", "Create new service successful");

        Service service1 = new Service();
        service1.setServiceType(service.getServiceType());
        if (service1.getServiceType().getName().equals("House"))
            return "service/house/create";
        else if (service1.getServiceType().getName().equals("Room"))
            return "service/room/create";
        else
            return "service/villa/create";    }
}
