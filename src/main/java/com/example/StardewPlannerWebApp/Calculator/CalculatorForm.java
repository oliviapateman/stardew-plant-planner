package com.example.StardewPlannerWebApp.Calculator;

import java.util.List;

public class CalculatorForm {

    @Override
    public String toString() {
        return "CalculatorForm{" +
                "dataList=" + dataList +
                '}';
    }

    private List<FormData> dataList;

    public List<FormData> getDataList() {
        return dataList;
    }

    public void setDataList(List<FormData> dataList) {
        this.dataList = dataList;
    }

}
