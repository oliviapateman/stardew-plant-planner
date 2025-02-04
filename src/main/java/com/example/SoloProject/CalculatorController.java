package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CalculatorController {

    @Autowired
    PlantsRepository plantsRepo;

    /*@RequestMapping("/calculator")
    public String getProfitTotal(@Param("quantities") List<Integer> quantities, Model model){
        model.addAttribute("quantities", quantities);
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        *//*TODO: calculation method
          - quantity * price *//*
        // probability crops --> 47% base, 33% silver, 20% gold
        // jar / wine --> base unless aged to silver and aged to gold
        return "calculatorPage";
    }*/

    @RequestMapping("/calculator")
    public String viewCalcPage(Model model){
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        return "calculatorPage";
    }

}
