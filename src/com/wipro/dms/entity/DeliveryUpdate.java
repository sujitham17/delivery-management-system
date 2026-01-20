package com.wipro.dms.entity;

public class DeliveryUpdate {

    private String updateId;
    private String deliveryId;
    private String date;
    private String notes;

    public DeliveryUpdate(String updateId, String deliveryId, String date, String notes) {
        this.updateId = updateId;
        this.deliveryId = deliveryId;
        this.date = date;
        this.notes = notes;
    }

    public String getUpdateId() {
        return updateId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
