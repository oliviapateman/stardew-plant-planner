package com.example.SoloProject;

public class Calculator {

    private int quantity;
    private boolean isTiller;
    private boolean isKeg;
    private boolean isKegArtisan;
    private boolean isJar;
    private boolean isJarArtisan;


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

    public boolean isKeg() {
        return isKeg;
    }

    public void setKeg(boolean keg) {
        isKeg = keg;
    }

    public boolean isKegArtisan() {
        return isKegArtisan;
    }

    public void setKegArtisan(boolean kegArtisan) {
        isKegArtisan = kegArtisan;
    }

    public boolean isJar() {
        return isJar;
    }

    public void setJar(boolean jar) {
        isJar = jar;
    }

    public boolean isJarArtisan() {
        return isJarArtisan;
    }

    public void setJarArtisan(boolean jarArtisan) {
        isJarArtisan = jarArtisan;
    }
}
