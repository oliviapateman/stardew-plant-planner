package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    PlantsRepository plantsRepo;

    @RequestMapping("/calendar")
    public String viewCalendarPage(Model model){
        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        return "calendarPage";
    }

}
