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
                    if (plant.isFlower()) {
                        if (data.isTiller()) {
                            addTillerCrops(plant, regular, silver, gold);
                        } else {
                            addNormalCrops(plant, regular, silver, gold);
                        }
                    } else if (data.isJar()) {
                        if (data.isArtisan()) {
                            addJarToArtisan(plant);
                        } else {
                            addToJar(plant, quantity);
                        }
                    } else if (data.isKeg()) {
                        if (data.isArtisan()) {
                            addKegToArtisan(plant);
                        } else {
                            addToKeg(plant, quantity);
                        }
                    } else if (data.isTiller()) {
                        addTillerCrops(plant, regular, silver, gold);
                    } else {
                        addNormalCrops(plant, regular, silver, gold);
                    }
                    addAllUp(data.isKeg(), data.isJar(), data.isArtisan());
                    break;
                }
            }
        }
    }

    public void addAllUp(boolean isKeg, boolean isJar, boolean isArtisan) {
        totalCrops = sumOfList(allNormalAndTillerCrops);
        if (isArtisan) {
            totalRegArtisan = sumOfList(allRegArtisan) + totalCrops;
            totalSilverArtisan = sumOfList(allSilverArtisan) + totalCrops;
            totalGoldArtisan = sumOfList(allGoldArtisan) + totalCrops;
        } else if (isKeg || isJar) {
            totalRegJarKeg = sumOfList(allRegJarAndKeg) + totalCrops;
            totalSilverJarKeg = sumOfList(allSilverJarAndKeg) + totalCrops;
            totalGoldJarKeg = sumOfList(allGoldJarAndKeg) + totalCrops;
        }
    }

    public int sumOfList(List<Integer> list) {
        int total = 0;
        for (int item : list) {
            total += item;
        }
        return total;
    }

    public void resetFields(){
        totalCrops = 0;
        totalRegJarKeg = 0;
        totalSilverJarKeg = 0;
        totalGoldJarKeg = 0;
        totalRegArtisan = 0;
        totalSilverArtisan = 0;
        totalGoldArtisan = 0;
        allRegArtisan.clear();
        allSilverArtisan.clear();
        allGoldArtisan.clear();
        allRegJarAndKeg.clear();
        allSilverJarAndKeg.clear();
        allGoldJarAndKeg.clear();
        allNormalAndTillerCrops.clear();
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

    private void addToJar(Plants plant, int quantity) {
        allRegJarAndKeg.add(plant.getJarPrice().get(0) * quantity);
        allSilverJarAndKeg.add(plant.getJarPrice().get(1) * quantity);
        allGoldJarAndKeg.add(plant.getJarPrice().get(2) * quantity);
    }

    private void addToKeg(Plants plant, int quantity) {
        allRegJarAndKeg.add(plant.getKegPrice().get(0) * quantity);
        allSilverJarAndKeg.add(plant.getKegPrice().get(1) * quantity);
        allGoldJarAndKeg.add(plant.getKegPrice().get(2) * quantity);
    }

    private void addTillerCrops(Plants plant, double regular, double silver, double gold) {
        allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(0) * regular));
        allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(1) * silver));
        allNormalAndTillerCrops.add((int) (plant.getTillerPrice().get(2) * gold));
    }

    private void addNormalCrops(Plants plant, double regular, double silver, double gold) {
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
