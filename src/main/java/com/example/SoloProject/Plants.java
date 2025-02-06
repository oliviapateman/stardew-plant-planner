package com.example.SoloProject;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Plants")
public class Plants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String seedName;
    private boolean isFruit;
    private boolean isFlower;
    private int month;
    // 1 - Spring, 2 - Summer, 3 - Fall, 4 - Winter

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> normalPrice;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "tiller", joinColumns = @JoinColumn(name = "plants_id"))
    private List<Integer> tillerPrice = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "keg", joinColumns = @JoinColumn(name = "plants_id"))
    private List<Integer> kegPrice = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "keg_artisan", joinColumns = @JoinColumn(name = "plants_id"))
    private List<Integer> kegArtisanPrice = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "jar", joinColumns = @JoinColumn(name = "plants_id"))
    private List<Integer> jarPrice;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "jar_artisan", joinColumns = @JoinColumn(name = "plants_id"))
    private List<Integer> jarArtisanPrice;

    public Plants(boolean isFruit, boolean isFlower, String seedName, int month, List<Integer> normalPrice) {
        this.isFruit = isFruit;
        this.isFlower = isFlower;
        this.seedName = seedName;
        this.month = month;
        this.normalPrice = normalPrice;
        this.tillerPrice = makeTillerPrices(normalPrice);
        this.kegPrice = makeKegPrices(normalPrice);
        this.jarPrice = makeJarPrices(normalPrice);
        this.kegArtisanPrice = makeKegArtisanPrices(this.kegPrice);
        this.jarArtisanPrice = makeJarArtisanPrices(this.jarPrice);
    }

    protected Plants() {
    }

    public List<Integer> getJarArtisanPrice() {
        return jarArtisanPrice;
    }

    public void setJarArtisanPrice(List<Integer> jarArtisanPrice) {
        this.jarArtisanPrice = jarArtisanPrice;
    }

    public List<Integer> getJarPrice() {
        return jarPrice;
    }

    public void setJarPrice(List<Integer> jarPrice) {
        this.jarPrice = jarPrice;
        this.jarArtisanPrice = makeJarArtisanPrices(jarPrice);
    }

    public List<Integer> getKegArtisanPrice() {
        return kegArtisanPrice;
    }

    public void setKegArtisanPrice(List<Integer> kegArtisanPrice) {
        this.kegArtisanPrice = kegArtisanPrice;
    }

    public List<Integer> getKegPrice() {
        return kegPrice;
    }

    public void setKegPrice(List<Integer> kegPrice) {
        this.kegPrice = kegPrice;
        this.kegArtisanPrice = makeKegArtisanPrices(kegPrice);
    }

    public List<Integer> getTillerPrice() {
        return tillerPrice;
    }

    public void setTillerPrice(List<Integer> tillerPrice) {
        this.tillerPrice = tillerPrice;
    }

    public List<Integer> getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(List<Integer> normalPrice) {
        this.normalPrice = normalPrice;
        this.tillerPrice = makeTillerPrices(normalPrice);
        this.kegPrice = makeKegPrices(normalPrice);
        this.jarPrice = makeJarPrices(normalPrice);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isFlower() {
        return isFlower;
    }

    public void setFlower(boolean flower) {
        isFlower = flower;
    }

    public boolean isFruit() {
        return isFruit;
    }

    public void setFruit(boolean fruit) {
        isFruit = fruit;
    }

    public String getSeedName() {
        return seedName;
    }

    public void setSeedName(String seedName) {
        this.seedName = seedName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> makeTillerPrices(List<Integer> normalPrice) {
        List<Integer> tillerPrice = new ArrayList<>();
        for (int price : normalPrice) {
            if (!isFlower) {
                tillerPrice.add((int) (price + (price * 0.1)));
            }
        }
        return tillerPrice;
    }

    public List<Integer> makeKegPrices(List<Integer> normalPrice) {
        List<Integer> kegPrice = new ArrayList<>();
        if (!isFlower) {
            for (int price : normalPrice) {
                if (isFruit) {
                    kegPrice.add(price * 3);
                } else {
                    kegPrice.add((int) (price * 2.25));
                }
            }
        }
        if (this.seedName.equals("Hops")) {
            kegPrice.add(300);
            kegPrice.add(375);
            kegPrice.add(450);
        }
        return kegPrice;
    }

    public List<Integer> makeJarPrices(List<Integer> normalPrice) {
        List<Integer> jarPrice = new ArrayList<>();
        for (int price : normalPrice) {
            if (!isFlower) {
                jarPrice.add(50 + (price * 2));
            }
        }
        return jarPrice;
    }

    public List<Integer> makeJarArtisanPrices(List<Integer> jarPrice) {
        List<Integer> jarArtisanPrice = new ArrayList<>();
        if (jarPrice != null) {
            for (int price : jarPrice) {
                jarArtisanPrice.add((int) (price + (price * 0.4)));
            }
            return jarArtisanPrice;
        } else {
            return null;
        }
    }

    public List<Integer> makeKegArtisanPrices(List<Integer> kegPrice) {
        List<Integer> kegArtisanPrice = new ArrayList<>();
        if (kegPrice != null) {
            for (int price : kegPrice) {
                kegArtisanPrice.add((int) (price + (price * 0.4)));
            }
            return kegArtisanPrice;
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        return "Plants{" +
                "id=" + id +
                ", seedName='" + seedName + '\'' +
                ", isFruit=" + isFruit +
                ", isFlower=" + isFlower +
                ", month=" + month +
                ", normalPrice=" + normalPrice +
                ", tillerPrice=" + tillerPrice +
                ", kegPrice=" + kegPrice +
                ", kegArtisanPrice=" + kegArtisanPrice +
                ", jarPrice=" + jarPrice +
                ", jarArtisanPrice=" + jarArtisanPrice +
                '}';
    }
}
