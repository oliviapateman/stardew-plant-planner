package com.example.SoloProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SoloProjectApplication {

	private static final Logger log = LoggerFactory.getLogger(SoloProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SoloProjectApplication.class, args);
	}

	//int id, boolean isFruit, boolean isFlower, String seedName, List<Integer> normalPrice
	@Bean
	public CommandLineRunner runner (PlantsRepository plantsRepo){
		return (args) -> {
			//Spring
			plantsRepo.save(new Plants(false, true, "Blue Jazz", 1, List.of(50, 62, 75)));
			plantsRepo.save(new Plants(false, false, "Carrot", 1, List.of(35, 43, 52)));
			plantsRepo.save(new Plants(false, false, "Cauliflower", 1, List.of(175, 218, 262)));
			plantsRepo.save(new Plants(false, false, "Green Bean", 1, List.of(40, 50, 60)));
			plantsRepo.save(new Plants(false, false, "Kale", 1, List.of(110, 137, 165)));
			plantsRepo.save(new Plants(false, false, "Parsnip", 1, List.of(35,43,52)));
			plantsRepo.save(new Plants(false, false, "Potato", 1, List.of(80,100,120)));
			plantsRepo.save(new Plants(true, false, "Strawberry", 1, List.of(120,150,180)));
			plantsRepo.save(new Plants(false, true, "Tulip", 1, List.of(30,37,45)));

			//Summer
			plantsRepo.save(new Plants(true, false, "Blueberry", 2, List.of(50, 62, 75)));
			plantsRepo.save(new Plants(false, true, "Hops", 2, List.of(25, 31, 37)));



			//Fall


			//Winter


			plantsRepo.findAll().forEach(plants -> log.info(plants.toString()));
		};
	}

}
