package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantsService {

    @Autowired
    PlantsRepository plantsRepo;

    public void updateFields(int id, int quantity, boolean tiller, boolean jar, boolean keg, boolean artisan) {
        Optional<Plants> plantsList = plantsRepo.findById(id);
        plantsList.ifPresent(plants -> {
            plants.setQuantity(quantity);
            plants.setTiller(tiller);
            plants.setJar(jar);
            plants.setKeg(keg);
            plants.setArtisan(artisan);
            plantsRepo.save(plants);
        });
    }

}
