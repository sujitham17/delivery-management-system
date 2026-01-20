package com.wipro.dms.service;

import java.util.ArrayList;
import java.util.Iterator;

import com.wipro.dms.entity.*;
import com.wipro.dms.util.*;

public class DeliveryService {

    private ArrayList<DeliveryAgent> agents;
    private ArrayList<DeliveryOrder> deliveries;
    private ArrayList<DeliveryUpdate> updates;

    public DeliveryService(ArrayList<DeliveryAgent> agents,
                           ArrayList<DeliveryOrder> deliveries,
                           ArrayList<DeliveryUpdate> updates) {
        this.agents = agents;
        this.deliveries = deliveries;
        this.updates = updates;
    }

    public DeliveryAgent findAgent(String agentId) throws AgentNotFoundException {
        for (DeliveryAgent agent : agents) {
            if (agent.getAgentId().equals(agentId)) {
                return agent;
            }
        }
        throw new AgentNotFoundException("Agent not found: " + agentId);
    }

    public void assignDelivery(String deliveryId, String agentId) throws AgentNotFoundException {
        DeliveryAgent agent = findAgent(agentId);
        if (!agent.isActive()) {
            throw new AgentNotFoundException("Agent is inactive");
        }
        deliveries.add(new DeliveryOrder(deliveryId, agentId, "ASSIGNED"));
    }

    public DeliveryOrder findDelivery(String deliveryId) throws DeliveryNotFoundException {
        for (DeliveryOrder d : deliveries) {
            if (d.getDeliveryId().equals(deliveryId)) {
                return d;
            }
        }
        throw new DeliveryNotFoundException("Delivery not found: " + deliveryId);
    }

    public void updateDeliveryStatus(String deliveryId, String newStatus)
            throws DeliveryNotFoundException {
        DeliveryOrder d = findDelivery(deliveryId);
        d.setStatus(newStatus);
    }

    public void addDeliveryUpdate(String deliveryId, String date, String notes)
            throws DeliveryNotFoundException, DeliveryOperationException {

        if (notes == null || notes.isEmpty()) {
            throw new DeliveryOperationException("Notes cannot be empty");
        }

        findDelivery(deliveryId);
        String updateId = "U" + (updates.size() + 1);
        updates.add(new DeliveryUpdate(updateId, deliveryId, date, notes));
    }

    public ArrayList<DeliveryUpdate> getDeliveryHistory(String deliveryId)
            throws DeliveryNotFoundException {

        findDelivery(deliveryId);
        ArrayList<DeliveryUpdate> history = new ArrayList<>();

        for (DeliveryUpdate u : updates) {
            if (u.getDeliveryId().equals(deliveryId)) {
                history.add(u);
            }
        }
        return history;
    }

    public void cancelDelivery(String deliveryId) throws DeliveryNotFoundException {
        findDelivery(deliveryId);

        deliveries.removeIf(d -> d.getDeliveryId().equals(deliveryId));
        updates.removeIf(u -> u.getDeliveryId().equals(deliveryId));
    }

    public void displayAgentDeliveries(String agentId) {
        for (DeliveryOrder d : deliveries) {
            if (d.getAgentId().equals(agentId)) {
                System.out.println(d.getDeliveryId() + " - " + d.getStatus());
            }
        }
    }

    public void displayAllDeliveries() {
        for (DeliveryOrder d : deliveries) {
            System.out.println(d.getDeliveryId() + " - " + d.getStatus());
        }
    }
}
