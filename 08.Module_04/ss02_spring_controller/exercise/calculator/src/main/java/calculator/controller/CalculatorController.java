package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @GetMapping("/calculator")
    public String showDictionary(){
        return "calculator";
    }
    @PostMapping("/calculator")
    public String dictionary(Model model, @RequestParam("cal") String cal, @RequestParam("number1") double number1, @RequestParam("number2") double number2){
        model.addAttribute("result", calculatorService.calculator(cal, number1, number2));
        model.addAttribute("cal", cal);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "calculator";
    }
}
