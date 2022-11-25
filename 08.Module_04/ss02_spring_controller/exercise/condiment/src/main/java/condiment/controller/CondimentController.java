package condiment.controller;

import condiment.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService dictionaryService;

    @GetMapping("/condiment")
    public String showDictionary(){
        return "/condiment";
    }
    @PostMapping("/condiment")
    public String dictionary(Model model, @RequestParam("condiment") String[] condiment){
//        model.addAttribute("result", dictionaryService.translateE(inputE));
//        model.addAttribute("inputE", inputE);
        return "/condiment";
    }
}
