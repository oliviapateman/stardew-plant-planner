package com.example.tests;

import com.example.StardewPlannerWebApp.Plants.Plants;
import com.example.StardewPlannerWebApp.Plants.PlantsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class PlantsRepositoryTests {

    @Autowired
    private PlantsRepository plantsRepo;

    private static final Logger log = LoggerFactory.getLogger(PlantsRepositoryTests.class);

    @BeforeEach
    public void beforeEach() {
        plantsRepo.deleteAll();
    }

    @Test
    public void savePlantTest() {
        Plants plant = new Plants(true, false, "Strawberry", 1, 8, List.of(120, 150, 180));
        plantsRepo.save(plant);
        assertTrue(plant.getId() > 0);
    }

    @Test
    public void fruitHasAllValues() {
        Plants fruit = new Plants(true, false, "Strawberry", 1, 8, List.of(120, 150, 180));
        plantsRepo.save(fruit);
        assertNotNull(fruit.getJarPrice());
        assertNotNull(fruit.getKegPrice());
        assertNotNull(fruit.getTillerPrice());
        assertNotNull(fruit.getJarArtisanPrice());
        assertNotNull(fruit.getKegArtisanPrice());
    }

    @Test
    public void vegHasAllValues() {
        Plants veg = new Plants(false, false, "Broccoli", 3, 8, List.of(70, 7, 105));
        plantsRepo.save(veg);
        assertNotNull(veg.getJarPrice());
        assertNotNull(veg.getKegPrice());
        assertNotNull(veg.getTillerPrice());
        assertNotNull(veg.getJarArtisanPrice());
        assertNotNull(veg.getKegArtisanPrice());
    }

    @Test
    public void flowerHasOnlyTillerAddedValues() {
        Plants flower = new Plants(false, true, "Fairy Rose", 3, 12, List.of(290, 362, 435));
        plantsRepo.save(flower);
        assertEquals(3, flower.getTillerPrice().size());
        assertEquals(0, flower.getJarPrice().size());
        assertEquals(0, flower.getKegPrice().size());
        assertEquals(0, flower.getJarArtisanPrice().size());
        assertEquals(0, flower.getKegArtisanPrice().size());
    }

    @Test
    public void getPlantsByMonth() {
        plantsRepo.save(new Plants(false, false, "Tomato", 2, 11, List.of(60, 75, 90)));
        plantsRepo.save(new Plants(false, false, "Wheat", 2, 4, List.of(25, 31, 37)));
        plantsRepo.save(new Plants(false, false, "Corn", 3, 14, List.of(50, 62, 75)));
        plantsRepo.save(new Plants(false, true, "Sunflower", 3, 8, List.of(80, 100, 120)));

        log.info(plantsRepo.findByMonth(2).toString());

        assertEquals(2, plantsRepo.findByMonth(2).size());
    }

    @Test
    public void getAllPlants() {
        plantsRepo.save(new Plants(false, false, "Tomato", 2, 11, List.of(60, 75, 90)));
        plantsRepo.save(new Plants(false, false, "Wheat", 2, 4, List.of(25, 31, 37)));
        plantsRepo.save(new Plants(false, false, "Corn", 3, 14, List.of(50, 62, 75)));
        plantsRepo.save(new Plants(false, true, "Sunflower", 3, 8, List.of(80, 100, 120)));

        List<Plants> plantsList = (List<Plants>) plantsRepo.findAll();

        assertEquals(4, plantsList.size());
    }

}
