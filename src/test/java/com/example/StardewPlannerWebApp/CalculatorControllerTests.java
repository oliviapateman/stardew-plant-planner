package com.example.StardewPlannerWebApp;

import com.example.StardewPlannerWebApp.Calculator.CalculatorController;
import com.example.StardewPlannerWebApp.Plants.Plants;
import com.example.StardewPlannerWebApp.Plants.PlantsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private CalculatorController calculatorController;

    @Autowired
    MockMvc mvc;

    @MockitoBean
    PlantsRepository plantsRepository;

    @BeforeEach
    public void beforeEach(){
        List<Plants> plantsList = new ArrayList<>();
        plantsList.add(new Plants(false, true, "Blue Jazz", 1, 7, List.of(50, 62, 75)));
        plantsList.add(new Plants(false, false, "Carrot", 1, 3, List.of(35, 43, 52)));
        when(plantsRepository.findAll()).thenReturn(plantsList);
    }

    @Test
    public void contextLoads(){
        assertNotNull(calculatorController);
    }

    @Test
    public void showCalculatorForm() throws Exception {
        mvc.perform(get("/calculator"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("form"));
    }

    @Test
    public void submitCalculatorForm() throws Exception {
        mvc.perform(post("/calculator")
                .param("dataList[0].quantity", "10")
                .param("dataList[1].quantity", "5"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/results"));
    }

}
