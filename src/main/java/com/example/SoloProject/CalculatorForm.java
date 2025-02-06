package com.example.SoloProject;

import java.util.List;

public class CalculatorForm {

    @Override
    public String toString() {
        return "CalculatorForm{" +
                "plantsList=" + plantsList +
                '}';
    }

    private List<Plants> plantsList;

    public List<Plants> getPlantsList() {
        return plantsList;
    }

    public void setPlantsList(List<Plants> plantsList) {
        this.plantsList = plantsList;
    }
}
