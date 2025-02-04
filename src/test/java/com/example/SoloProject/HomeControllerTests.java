package com.example.SoloProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HomeControllerTests {

    @Autowired
    private HomeController homeController;

    @Test
    public void contextLoads(){
        assertNotNull(homeController);
    }

}
