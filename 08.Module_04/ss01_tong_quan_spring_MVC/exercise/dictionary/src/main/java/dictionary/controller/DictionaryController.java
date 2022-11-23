package dictionary.controller;

import dictionary.service.IDictionaryService;
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

    @GetMapping("/dictionary")
    public String showDictionary(){
        return "/dictionary";
    }
    @PostMapping("/dictionary")
    public String dictionary(Model model, @RequestParam("inputE") String inputE){
        model.addAttribute("result", dictionaryService.translateE(inputE));
        model.addAttribute("inputE", inputE);
        return "/dictionary";
    }
}
