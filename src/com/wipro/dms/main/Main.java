package com.wipro.dms.main;
import java.util.ArrayList;
import com.wipro.dms.entity.*;
import com.wipro.dms.service.DeliveryService;
import com.wipro.dms.util.*;
public class Main {
 public static void main(String[] args) {
 ArrayList<DeliveryAgent> agents = new ArrayList<>();
 agents.add(new DeliveryAgent("A001", "Suresh", true));
 agents.add(new DeliveryAgent("A002", "Priya", true));
 ArrayList<DeliveryOrder> deliveries = new ArrayList<>();
 ArrayList<DeliveryUpdate> updates = new ArrayList<>();
 DeliveryService service = new DeliveryService(agents, deliveries, updates);
 try {
 System.out.println("--- Assigning Delivery ---");
 service.assignDelivery("D001", "A001");
 System.out.println("--- Updating Delivery ---");
 service.updateDeliveryStatus("D001", "PICKED_UP");
 service.addDeliveryUpdate("D001", "2025-08-15", "Package picked up from store.");
 service.updateDeliveryStatus("D001", "OUT_FOR_DELIVERY");
 service.addDeliveryUpdate("D001", "2025-08-16", "Reached local hub.");
 service.updateDeliveryStatus("D001", "DELIVERED");
		 System.out.println("\n--- Delivery History ---");
 for (DeliveryUpdate du : service.getDeliveryHistory("D001")) {
	 System.out.println(du.getNotes());
 }
 System.out.println("\n--- Agent Deliveries (A001) ---");
 service.displayAgentDeliveries("A001");
 System.out.println("\n--- All Deliveries ---");
 service.displayAllDeliveries();
 } catch (AgentNotFoundException | DeliveryNotFoundException |
 DeliveryOperationException ex) {
	 System.out.println(ex);
 }
 }
}