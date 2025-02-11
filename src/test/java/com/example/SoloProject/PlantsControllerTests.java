package com.example.SoloProject;

import com.example.SoloProject.Plants.PlantsController;
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
public class PlantsControllerTests {

    @Autowired
    private PlantsController plantsController;

    @Autowired
    MockMvc mvc;

    @Test
    public void contextLoads(){
        assertNotNull(plantsController);
    }

    @Test
    public void dataPageReturnsOk() throws Exception {
        mvc.perform(get("/crops")).andExpect(status().isOk());
    }
}
