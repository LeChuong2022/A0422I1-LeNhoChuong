package medical.controller;

import medical.bean.InformationPeople;
import medical.bean.Symptom;
import medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/medical")
public class MedicalController {
    @Autowired
    IMedicalService medicalService;

    @GetMapping("/save")
    public String showMedicalForm(Model model){
        model.addAttribute("info", new InformationPeople());
        model.addAttribute("symptom", new Symptom());
        return "form-medical";
    }

    @PostMapping("/save")
    public String doSave(@ModelAttribute("info")InformationPeople info, @ModelAttribute("symptom")Symptom symptom, Model model){
        Map<String, String> errorMap = medicalService.save(info, symptom);
        String mess = "Gửi tờ khai thành công";
        if (!errorMap.isEmpty()){
            model.addAttribute("name", errorMap.get("name"));
            model.addAttribute("yearOfBirth", errorMap.get("yearOfBirth"));
            model.addAttribute("gender", errorMap.get("gender"));
            model.addAttribute("nationality", errorMap.get("nationality"));
            model.addAttribute("creditId", errorMap.get("creditId"));
            model.addAttribute("vehicle", errorMap.get("vehicle"));
            model.addAttribute("dayStart", errorMap.get("dayStart"));
            model.addAttribute("dayEnd", errorMap.get("dayEnd"));
            model.addAttribute("cityTravel", errorMap.get("cityTravel"));
            model.addAttribute("cityAddress", errorMap.get("cityAddress"));
            model.addAttribute("districtAddress", errorMap.get("districtAddress"));
            model.addAttribute("wardAddress", errorMap.get("wardAddress"));
            model.addAttribute("address", errorMap.get("address"));
            model.addAttribute("phone", errorMap.get("phone"));
            model.addAttribute("fever", errorMap.get("fever"));
            model.addAttribute("nausea", errorMap.get("nausea"));
            model.addAttribute("cough", errorMap.get("cough"));
            model.addAttribute("diarrhea", errorMap.get("diarrhea"));
            model.addAttribute("shortnessOfBreath", errorMap.get("shortnessOfBreath"));
            model.addAttribute("skinHemorrhage", errorMap.get("skinHemorrhage"));
            model.addAttribute("soreThroat", errorMap.get("soreThroat"));
            model.addAttribute("skinRash", errorMap.get("skinRash"));
            model.addAttribute("travelEpidemicPlace", errorMap.get("travelEpidemicPlace"));
            model.addAttribute("closeContact", errorMap.get("closeContact"));
            model.addAttribute("info", info);
            model.addAttribute("symptom", symptom);
            mess = "Gửi tờ khai không thành công";
        }
        model.addAttribute("mess", mess);
        return "form-medical";

    }





//    @PostMapping("/calculator")
//    public String dictionary(Model model, @RequestParam("cal") String cal, @RequestParam("number1") double number1, @RequestParam("number2") double number2){
//        model.addAttribute("result", calculatorService.calculator(cal, number1, number2));
//        model.addAttribute("cal", cal);
//        model.addAttribute("number1", number1);
//        model.addAttribute("number2", number2);
//        return "calculator";
//    }
}
