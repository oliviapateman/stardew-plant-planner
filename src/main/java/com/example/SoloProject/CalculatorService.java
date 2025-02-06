package com.example.SoloProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    PlantsRepository plantsRepo;

    int quantity;

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

    public void calculateProfits(List<FormData> formDataList) {
        for (Plants plant : plantsRepo.findAll()) {
            for (FormData data : formDataList) {
                if (data.getId() == plant.getId()) {
                    quantity = data.getQuantity();
                    double regular = quantity * 0.47;
                    double silver = quantity * 0.33;
                    double gold = quantity * 0.2;
                    if (plant.isFlower()){
                        addToCrops(plant, regular, silver, gold);
                    } else if (data.isArtisan()) {
                        if (data.isJar()) {
                            addJarToArtisan(plant);
                        } else if (data.isKeg()) {
                            addKegToArtisan(plant);
                        }
                    } else if (data.isJar()) {
                        addToJar(plant, regular, silver, gold);
                    } else if (data.isKeg()) {
                        addToKeg(plant, regular, silver, gold);
                    } else if (data.isTiller()) {
                        addToCrops(plant, regular, silver, gold);
                    } else {
                        addToCrops(plant, regular, silver, gold);
                    }
                    break;
                }
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

    private void addJarToArtisan(Plants plant) {
        allRegArtisan.add(plant.getJarArtisanPrice().get(0) * quantity);
        allSilverArtisan.add(plant.getJarArtisanPrice().get(1) * quantity);
        allGoldArtisan.add(plant.getJarArtisanPrice().get(2) * quantity);
    }

    private void addKegToArtisan(Plants plant) {
        allRegArtisan.add(plant.getKegArtisanPrice().get(0) * quantity);
        allSilverArtisan.add(plant.getKegArtisanPrice().get(1) * quantity);
        allGoldArtisan.add(plant.getKegArtisanPrice().get(2) * quantity);
    }

    private void addToJar(Plants plant, double regular, double silver, double gold) {
        allRegJarAndKeg.add((int) (plant.getJarPrice().get(0) * regular));
        allSilverJarAndKeg.add((int) (plant.getJarPrice().get(1) * silver));
        allGoldJarAndKeg.add((int) (plant.getJarPrice().get(2) * gold));
    }

    private void addToKeg(Plants plant, double regular, double silver, double gold) {
        allRegJarAndKeg.add((int) (plant.getKegPrice().get(0) * regular));
        allSilverJarAndKeg.add((int) (plant.getKegPrice().get(1) * silver));
        allGoldJarAndKeg.add((int) (plant.getKegPrice().get(2) * gold));
    }

    private void addToCrops(Plants plant, double regular, double silver, double gold) {
        allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(0) * regular));
        allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(1) * silver));
        allNormalAndTillerCrops.add((int) (plant.getNormalPrice().get(2) * gold));
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
