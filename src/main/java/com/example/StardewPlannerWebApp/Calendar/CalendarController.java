package com.example.StardewPlannerWebApp.Calendar;

import com.example.StardewPlannerWebApp.Plants.Plants;
import com.example.StardewPlannerWebApp.Plants.PlantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    PlantsRepository plantsRepo;

    @GetMapping("/calendar")
    public String viewCalendarPage(Model model){
        //28 Days
        LocalDate startDate = LocalDate.of(2025, 2, 1);

        List<LocalDate> dayOfMonth = new ArrayList<>();
        for (int i=0; i<28; i++) {
            dayOfMonth.add(startDate.plusDays(i));
        }

        List<List<LocalDate>> weeks = new ArrayList<>();
        for (int i=0; i< 28; i+=7){
            weeks.add(dayOfMonth.subList(i, i+7));
        }

        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();
        model.addAttribute("listPlants", plantsList);
        model.addAttribute("dayOfMonth", dayOfMonth);
        model.addAttribute("weeks", weeks);
        return "calendarPage";
    }

}
