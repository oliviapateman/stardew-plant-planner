package com.example.StardewPlannerWebApp.Calculator;

public class FormData {

    private int id;
    private boolean isArtisan;
    private boolean isKeg;
    private boolean isJar;
    private boolean isTiller;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTiller() {
        return isTiller;
    }

    public void setTiller(boolean tiller) {
        isTiller = tiller;
    }

    public boolean isJar() {
        return isJar;
    }

    public void setJar(boolean jar) {
        isJar = jar;
    }

    public boolean isKeg() {
        return isKeg;
    }

    public void setKeg(boolean keg) {
        isKeg = keg;
    }

    public boolean isArtisan() {
        return isArtisan;
    }

    public void setArtisan(boolean artisan) {
        isArtisan = artisan;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "id=" + id +
                ", isArtisan=" + isArtisan +
                ", isKeg=" + isKeg +
                ", isJar=" + isJar +
                ", isTiller=" + isTiller +
                ", quantity=" + quantity +
                '}';
    }
}
