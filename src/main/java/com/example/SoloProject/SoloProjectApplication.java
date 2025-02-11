package com.example.SoloProject;

import com.example.SoloProject.Plants.Plants;
import com.example.SoloProject.Plants.PlantsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SoloProjectApplication {

    private static final Logger log = LoggerFactory.getLogger(SoloProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SoloProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(PlantsRepository plantsRepo) {
        return (args) -> {
            //Spring
            plantsRepo.save(new Plants(false, true, "Blue Jazz", 1, 7, List.of(50, 62, 75)));
            plantsRepo.save(new Plants(false, false, "Carrot", 1, 3, List.of(35, 43, 52)));
            plantsRepo.save(new Plants(false, false, "Cauliflower", 1, 12, List.of(175, 218, 262)));
            plantsRepo.save(new Plants(false, false, "Green Bean", 1, 10, List.of(40, 50, 60)));
            plantsRepo.save(new Plants(false, false, "Kale", 1, 6, List.of(110, 137, 165)));
            plantsRepo.save(new Plants(false, false, "Parsnip", 1, 4,List.of(35, 43, 52)));
            plantsRepo.save(new Plants(false, false, "Potato", 1, 6, List.of(80, 100, 120)));
            plantsRepo.save(new Plants(true, false, "Strawberry", 1, 8, List.of(120, 150, 180)));
            plantsRepo.save(new Plants(false, true, "Tulip", 1, 6, List.of(30, 37, 45)));

            //Summer
            plantsRepo.save(new Plants(true, false, "Blueberry", 2, 13, List.of(50, 62, 75)));
            plantsRepo.save(new Plants(false, false, "Corn", 2, 14, List.of(50, 62, 75)));
            plantsRepo.save(new Plants(false, false, "Hops", 2, 11, List.of(25, 31, 37)));
            plantsRepo.save(new Plants(true, false, "Hot Pepper", 2, 5, List.of(40, 50, 60)));
            plantsRepo.save(new Plants(true, false, "Melon", 2, 12, List.of(250, 312, 375)));
            plantsRepo.save(new Plants(false, true, "Poppy", 2, 7, List.of(140, 175, 210)));
            plantsRepo.save(new Plants(false, false, "Radish", 2, 6, List.of(90, 112, 135)));
            plantsRepo.save(new Plants(false, true, "Summer Spangle", 2, 8, List.of(90, 112, 135)));
            plantsRepo.save(new Plants(true, false, "Summer Squash", 2, 6, List.of(45, 56, 67)));
            plantsRepo.save(new Plants(false, true, "Sunflower", 2, 8, List.of(80, 100, 120)));
            plantsRepo.save(new Plants(false, false, "Tomato", 2, 11, List.of(60, 75, 90)));
            plantsRepo.save(new Plants(false, false, "Wheat", 2, 4, List.of(25, 31, 37)));

            //Fall
            plantsRepo.save(new Plants(false, false, "Corn", 3, 14, List.of(50, 62, 75)));
            plantsRepo.save(new Plants(false, true, "Sunflower", 3, 8, List.of(80, 100, 120)));
            plantsRepo.save(new Plants(false, false, "Wheat", 3, 4, List.of(25, 31, 37)));
            plantsRepo.save(new Plants(false, false, "Amaranth", 3, 7, List.of(150, 187, 225)));
            plantsRepo.save(new Plants(false, false, "Artichoke", 3, 8, List.of(160, 200, 240)));
            plantsRepo.save(new Plants(false, false, "Bok Choy", 3, 4, List.of(80, 100, 120)));
            plantsRepo.save(new Plants(false, false, "Broccoli", 3, 8, List.of(70, 7, 105)));
            plantsRepo.save(new Plants(true, false, "Cranberries", 3, 7, List.of(75, 93, 112)));
            plantsRepo.save(new Plants(false, false, "Eggplant", 3, 5, List.of(60, 75, 90)));
            plantsRepo.save(new Plants(false, true, "Fairy Rose", 3, 12, List.of(290, 362, 435)));
            plantsRepo.save(new Plants(true, false, "Grape", 3, 10, List.of(80, 100, 120)));
            plantsRepo.save(new Plants(false, false, "Pumpkin", 3, 13, List.of(320, 400, 480)));
            plantsRepo.save(new Plants(false, false, "Yam", 3, 10, List.of(160, 200, 240)));

            //Winter
            plantsRepo.save(new Plants(true, false, "Powdermelon", 4, 7, List.of(60, 75, 90)));

            plantsRepo.findAll().forEach(plants -> log.info(plants.toString()));
        };
    }

}
