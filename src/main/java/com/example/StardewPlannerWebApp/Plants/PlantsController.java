package com.example.StardewPlannerWebApp.Plants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PlantsController {

    @Autowired
    PlantsRepository plantsRepository;

    @RequestMapping("/crops")
    public String viewCropDatabasePage(Model model){
        List<Plants> plantsList = (List<Plants>) plantsRepository.findAll();
        model.addAttribute("listPlants", plantsList);
        return "dataPage";
    }

}
