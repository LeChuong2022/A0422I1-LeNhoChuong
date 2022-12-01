package setting_mail.controller;

import setting_mail.bean.SettingMail;
import setting_mail.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import setting_mail.service.ISettingMailService;

import java.util.Map;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    IMailService mailService;

    @Autowired
    ISettingMailService settingMailService;

    @RequestMapping(method = RequestMethod.GET, value = {"/list"})
    public String displayList(Model model) {
        model.addAttribute("mail", mailService.findAll());
        model.addAttribute("settingMail", settingMailService.find());
        return "/mail/list";
    }

    @GetMapping("/setting")
    public String showFormCreate(Model model) {
        model.addAttribute("settingMail", settingMailService.find());
        String[] languageList = {"English", "Vietnamese", "Japanese", "Chinese"};
        model.addAttribute("languageList", languageList);
        Integer[] amountList = {5, 10, 15, 25, 50, 100};
        model.addAttribute("amountList", amountList);
        return "/mail/setting";
    }

    @PostMapping("/setting")
    public String create(@ModelAttribute("settingMail") SettingMail temp,
                         RedirectAttributes redirectAttributes) {
        String mess = "Upload successful";
        settingMailService.save(temp);
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/mail/list";
    }
}
