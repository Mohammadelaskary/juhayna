package com.example.juhayna.Model;

public class Order {
    private String plant;
    private String sku;
    private int qty;
    private String productionDate;
    private String orderType;

    public Order(String plant, String sku, int qty, String productionDate, String orderType) {
        this.plant = plant;
        this.sku = sku;
        this.qty = qty;
        this.productionDate = productionDate;
        this.orderType = orderType;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
