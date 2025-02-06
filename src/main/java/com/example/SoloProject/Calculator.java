package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Calculator {

    @Autowired
    PlantsRepository plantsRepo;

    int quantity;
    double regular = quantity / 0.47;
    double silver = quantity / 0.33;
    double gold = quantity / 0.2;

    List<Integer> allRegArtisan = new ArrayList<>();
    int totalRegArtisan;
    List<Integer> allSilverArtisan = new ArrayList<>();
    int totalSilverArtisan;
    List<Integer> allGoldArtisan = new ArrayList<>();
    int totalGoldArtisan;
    List<Integer> allRegJarAndKeg = new ArrayList<>();
    int totalRegJarKeg;
    List<Integer> allSilverJarAndKeg = new ArrayList<>();
    int totalSilverJarKeg;
    List<Integer> allGoldJarAndKeg = new ArrayList<>();
    int totalGoldJarKeg;
    List<Integer> allNormalAndTillerCrops = new ArrayList<>();
    int totalCrops;

    public void calculateProfits() {
        for (Plants plant : plantsRepo.findAll()) {
            quantity = plant.getQuantity();
            if (plant.isArtisan()) {
                if (plant.isJar()){
                    allRegArtisan.add(plant.getJarArtisanPrice().get(0) * quantity);
                    allSilverArtisan.add(plant.getJarArtisanPrice().get(1) * quantity);
                    allGoldArtisan.add(plant.getJarArtisanPrice().get(2) * quantity);
                } else if (plant.isKeg()){
                    allRegArtisan.add(plant.getKegArtisanPrice().get(0) * quantity);
                    allSilverArtisan.add(plant.getKegArtisanPrice().get(1) * quantity);
                    allGoldArtisan.add(plant.getKegArtisanPrice().get(2) * quantity);
                }
            } else if (plant.isJar()) {
                allRegJarAndKeg.add((int) (plant.getJarPrice().get(0) * regular));
                allSilverJarAndKeg.add((int) (plant.getJarPrice().get(1) * silver));
                allGoldJarAndKeg.add((int) (plant.getJarPrice().get(2) * gold));
            } else if (plant.isKeg()) {
                allRegJarAndKeg.add((int) (plant.getKegPrice().get(0) * regular));
                allSilverJarAndKeg.add((int) (plant.getKegPrice().get(1) * silver));
                allGoldJarAndKeg.add((int) (plant.getKegPrice().get(2) * gold));
            } else if (plant.isTiller()) {
                allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(0) * regular));
                allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(1) * silver));
                allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(2) * gold));
            } else {
                allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(0) * regular));
                allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(1) * silver));
                allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(2) * gold));
            }
        }
        addAllUp();
    }

    public void addAllUp() {
        totalRegArtisan = sumOfList(allRegArtisan);
        totalSilverArtisan = sumOfList(allSilverArtisan);
        totalGoldArtisan = sumOfList(allGoldArtisan);
        totalRegJarKeg = sumOfList(allRegJarAndKeg);
        totalSilverJarKeg = sumOfList(allSilverJarAndKeg);
        totalGoldJarKeg = sumOfList(allGoldJarAndKeg);
        totalCrops = sumOfList(allNormalAndTillerCrops);
    }

    public int sumOfList(List<Integer> list) {
        int total = 0;
        for (int item : list) {
            total += item;
        }
        return total;
    }

    public int getTotalRegArtisan() {
        return totalRegArtisan;
    }

    public int getTotalSilverArtisan() {
        return totalSilverArtisan;
    }

    public int getTotalGoldArtisan() {
        return totalGoldArtisan;
    }

    public int getTotalRegJarKeg() {
        return totalRegJarKeg;
    }

    public int getTotalSilverJarKeg() {
        return totalSilverJarKeg;
    }

    public int getTotalGoldJarKeg() {
        return totalGoldJarKeg;
    }

    public int getTotalCrops() {
        return totalCrops;
    }

}
