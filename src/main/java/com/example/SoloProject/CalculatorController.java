package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    PlantsRepository plantsRepo;

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String viewCalcPage(Model model){
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        model.addAttribute("plant", new Plants());
        model.addAttribute("form", new FormData());
        return "calculatorPage";
    }

    @PostMapping("/calculator")
    public String calcForm(CalculatorForm calculatorForm, Model model){
        calculatorService.calculateProfits(calculatorForm.getDataList());
        model.addAttribute("calc", calculatorService);
        return "calculatorResults";
    }

}
