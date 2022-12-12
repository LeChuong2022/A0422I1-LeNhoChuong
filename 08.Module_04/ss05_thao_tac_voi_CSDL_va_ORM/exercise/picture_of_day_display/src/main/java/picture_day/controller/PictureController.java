package picture_day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import picture_day.bean.PictureRate;
import picture_day.repository.IPictureRepository;
import picture_day.service.IPictureService;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class PictureController {
    @Autowired
    IPictureService pictureService;

    @GetMapping("/view")
    public String displayPicture(Model model){
        model.addAttribute("picture", new PictureRate());
        List<PictureRate> pictureRateList = pictureService.findAll();
        model.addAttribute("pictures", pictureService.findAll());
        return "list";
    }

    @PostMapping("/create")
    public String createComment(@ModelAttribute("picture") PictureRate pictureRate){
        pictureService.create(pictureRate);
        return "redirect:/view";
    }

    @GetMapping("/update")
    public String updateLike(@RequestParam("id") long id){
        pictureService.updateLike(id);
        return "redirect:/view";
    }

}
