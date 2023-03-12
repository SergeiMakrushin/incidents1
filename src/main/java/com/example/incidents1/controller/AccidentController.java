package com.example.incidents1.controller;

import com.example.incidents1.model.Accident;
import com.example.incidents1.service.AccidentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor

public class AccidentController {
    private final AccidentService accidentService;

    @GetMapping("/allAccidents")
    public String getPageAccidents(Model model) {
        model.addAttribute("accidents",accidentService.findAllAccident());
     return "accidents/listAccident";
    }

    @GetMapping ("/createAccident")
    public String getPagetCreate() {
        return "accidents/createAccidentPage";
    }

    @PostMapping("/saveAccidents")
    public String save(@ModelAttribute Accident accident) {
        accidentService.saveAccident(accident);
        return "redirect:/allAccidents";

    }
}
