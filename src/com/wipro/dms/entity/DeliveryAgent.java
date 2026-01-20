package com.wipro.dms.entity;

public class DeliveryAgent {

    private String agentId;
    private String name;
    private boolean active;

    public DeliveryAgent(String agentId, String name, boolean active) {
        this.agentId = agentId;
        this.name = name;
        this.active = active;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
