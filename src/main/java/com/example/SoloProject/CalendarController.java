package com.example.SoloProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {

    @RequestMapping("/calendar")
    public String viewCalendarPage(){
        return "calendarPage";
    }

}
