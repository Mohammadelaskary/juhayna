package com.example.juhayna.Model;

public class Picking {
    private String itemDesc;
    private int units;
    private int cartons;
    private int pallets;

    public Picking(String itemDesc, int units, int cartons, int pallets) {
        this.itemDesc = itemDesc;
        this.units = units;
        this.cartons = cartons;
        this.pallets = pallets;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getCartons() {
        return cartons;
    }

    public void setCartons(int cartons) {
        this.cartons = cartons;
    }

    public int getPallets() {
        return pallets;
    }

    public void setPallets(int pallets) {
        this.pallets = pallets;
    }
}
