package com.example.StardewPlannerWebApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    MockMvc mvc;

    @Test
    public void contextLoads(){
        assertNotNull(homeController);
    }

    @Test
    public void homePageReturnsOk() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk());
    }

}
