package com.wipro.dms.entity;

public class DeliveryOrder {

    private String deliveryId;
    private String agentId;
    private String status;

    public DeliveryOrder(String deliveryId, String agentId, String status) {
        this.deliveryId = deliveryId;
        this.agentId = agentId;
        this.status = status;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
