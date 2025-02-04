package com.example.SoloProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SoloProjectApplicationTests {

	@Autowired
	MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void homePageReturnsOk() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void dataPageReturnsOk() throws Exception {
		mvc.perform(get("/crops")).andExpect(status().isOk());
	}

	@Test
	public void calculatorPageReturnsOk() throws Exception {
		mvc.perform(get("/calculator")).andExpect(status().isOk());
	}


}
