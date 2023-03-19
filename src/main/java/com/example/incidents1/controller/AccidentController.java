package com.example.incidents1.controller;

import com.example.incidents1.model.Accident;
import com.example.incidents1.model.AccidentType;
import com.example.incidents1.model.Rule;
import com.example.incidents1.service.AccidentService;
import com.example.incidents1.service.AccidentTypeService;
import com.example.incidents1.service.RuleSevice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor

public class AccidentController {
    private final AccidentService accidentService;
    private final AccidentTypeService accidentTypeService;
    private final RuleSevice ruleService;


    @GetMapping("/allAccidents")
    public String getPageAccidents(Model model) {
        model.addAttribute("accidents", accidentService.findAllAccident());
        return "accidents/listAccident";
    }

    @GetMapping("/createAccident")
    public String getPagetCreate(Model model) {
        model.addAttribute("types", accidentTypeService.getAll());
        model.addAttribute("rules", ruleService.getAll());
        return "accidents/formCreate";
    }

    @PostMapping("/saveAccidents")
    public String save(@ModelAttribute Accident accident, @RequestParam("type.id") int typeId, @RequestParam("rIds") List<Integer> rIdsList, Model model) {
        Optional<AccidentType> optional = accidentTypeService.getAccidentTypeById(typeId);
        Set<Rule> rule = ruleService.getRuleById(rIdsList);
        boolean isCreate = accidentService.saveAccident(accident, optional, rule);
        if (!isCreate) {
            model.addAttribute("message", "не сохранено");
            return "errors/404";
        }
        return "redirect:/allAccidents";

    }
}
