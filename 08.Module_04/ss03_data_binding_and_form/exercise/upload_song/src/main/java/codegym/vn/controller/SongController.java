package codegym.vn.controller;

import codegym.vn.bean.Song;
import codegym.vn.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @RequestMapping(method = RequestMethod.GET, value = {"/list"})
    public String displayList(Model model) {
        model.addAttribute("song", songService.findAll());
        return "/song/list";
    }

    @GetMapping("/upload")
    public String showFormCreate(Model model, @ModelAttribute("song") Song temp) {
        model.addAttribute("song", temp);
        String[] typeList = {"acoustic", "pop", "rock", "county"};
        model.addAttribute("typeList", typeList);
        return "song/upload";
    }

    @PostMapping("/upload")
    public String create(@ModelAttribute("song") Song temp,
                         RedirectAttributes redirectAttributes) {
        String mess = "Upload successful";
        Map<String, String> errorMap = songService.create(temp);
        if (!errorMap.isEmpty()){
            redirectAttributes.addFlashAttribute("name", temp.getName());
            mess = "Upload unsuccessful";
            redirectAttributes.addFlashAttribute("mess", mess);
            redirectAttributes.addFlashAttribute("errorMap", errorMap);
            redirectAttributes.addFlashAttribute("song", temp);
            return "redirect:/song/upload";
        }
        redirectAttributes.addFlashAttribute("mess", mess);
        return "redirect:/song/list";
    }
}
