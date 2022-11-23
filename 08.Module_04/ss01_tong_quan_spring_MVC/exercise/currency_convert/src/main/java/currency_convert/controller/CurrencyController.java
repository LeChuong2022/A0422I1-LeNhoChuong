package currency_convert.controller;

import currency_convert.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    ICurrencyService currencyService;

    @GetMapping("/currency")
    public String showCurrencyConvert(){
        return "/currency";
    }
    @PostMapping("/currency")
    public String currencyConvert(Model model, @RequestParam("amount") double amount, @RequestParam("inputC") String inputC, @RequestParam("outputC") String outputC){
        model.addAttribute("result", currencyService.currencyConvert(amount, inputC, outputC));
        model.addAttribute("inputC", inputC);
        model.addAttribute("outputC", outputC);
        model.addAttribute("amount", amount);
        return "/currency";
    }
}
