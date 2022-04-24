package com.example.juhayna.Model;

public class WorkOrder {
    private int workOrderNo;
    private String itemDescription;
    private int workOrderQty;
    private int receivedQty;
    private String productionLine;

    public WorkOrder(int workOrderNo, String itemDescription, int workOrderQty, int receivedQty, String productionLine) {
        this.workOrderNo = workOrderNo;
        this.itemDescription = itemDescription;
        this.workOrderQty = workOrderQty;
        this.receivedQty = receivedQty;
        this.productionLine = productionLine;
    }

    public int getWorkOrderNo() {
        return workOrderNo;
    }

    public void setWorkOrderNo(int workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getWorkOrderQty() {
        return workOrderQty;
    }

    public void setWorkOrderQty(int workOrderQty) {
        this.workOrderQty = workOrderQty;
    }

    public int getReceivedQty() {
        return receivedQty;
    }

    public void setReceivedQty(int receivedQty) {
        this.receivedQty = receivedQty;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }
}
