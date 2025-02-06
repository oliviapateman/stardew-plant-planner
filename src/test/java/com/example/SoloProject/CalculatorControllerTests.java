package com.example.SoloProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private CalculatorController calculatorController;

    @Autowired
    MockMvc mvc;

    @Test
    public void contextLoads(){
        assertNotNull(calculatorController);
    }

    @Test
    public void calculatorPageReturnsOk() throws Exception {
        mvc.perform(get("/calculator")).andExpect(status().isOk());
    }

}
