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
    PlantsService plantsService;

    Calculator calculator = new Calculator();

    @GetMapping("/calculator")
    public String viewCalcPage(Model model){
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        model.addAttribute("plant", new Plants());
        return "calculatorPage";
    }

    @PostMapping("/calculator")
    public String calcForm(CalculatorForm calculatorForm){
        System.out.println(calculatorForm.toString());
        return "calculatorPage";
    }

    /*@PostMapping("/calculator")
    public String showTotalResult(@RequestParam("id") Integer id,
                                  @RequestParam("quantity") int quantity,
                                  @RequestParam("isTiller") boolean tiller,
                                  @RequestParam("isJar") boolean jar,
                                  @RequestParam("isKeg") boolean keg,
                                  @RequestParam("isArtisan") boolean artisan){
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        plantsService.updateFields(id, quantity, tiller, jar, keg, artisan);
        calculator.calculateProfits();
        //TODO: create result page
        return "calculatorPage";
    }*/

}
