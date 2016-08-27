package com.logztechstuff.discounts.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.logztechstuff.discounts.dao.InventoryDao;
import com.logztechstuff.discounts.dao.InventoryDaoImpl;

public class DiscountOnApparel {
	
	private final Scanner scanner;
	private final PurchaseProcessor purchaseProcessor;
	private final InventoryProcessor inventoryProcessor;
	
	public DiscountOnApparel(final Scanner scanner, final InventoryProcessor inventoryProcessor,
			final PurchaseProcessor purchaseProcessor) {
		this.scanner = scanner;
		this.inventoryProcessor = inventoryProcessor;
		this.purchaseProcessor = purchaseProcessor;
	}
	
	public void buildInventory() {
		List<String> inventories = getInventory();
		inventoryProcessor.addToInventory(inventories);
	}
	
	public void processOrders() {
		List<String> orders = getOrders();
		List<Double> bills = purchaseProcessor.calculateTotalBill(orders);
		System.out.println("Bills in the order as purchase items entered::");
		for(double bill : bills) {
			System.out.println(bill);
		}
	}
	
	private List<String> getInventory() {
		
		final List<String> inventories = new ArrayList<>();
		
		System.out.println("Enter total items to be added to inventory::");
		
		int totalApparel = scanner.nextInt();

		System.out.println("Enter items one by one::");
		
		do {
			String line = scanner.nextLine();
			if(!line.isEmpty())
				inventories.add(line);
		} while(inventories.size() != totalApparel);
		
		return inventories;
	}
	
	
	private List<String> getOrders() {
		
		System.out.println("Enter total number of orders::");
		
		int totalOrders = scanner.nextInt();
		
		System.out.println("Enter order details one by one::");
		
		List<String> orders = new ArrayList<>();
		
		do {
			String line = scanner.nextLine();
			if(!line.isEmpty()) 
				orders.add(line);
		} while(orders.size() != totalOrders);

		return orders;
	}
	
	public static void main(String[] args) {
		
		final Scanner scanner = new Scanner(System.in);
		
		final InventoryDao inventoryDao = new InventoryDaoImpl();
		
		final InventoryProcessor processor = new InventoryProcessor(inventoryDao);
		
		final PurchaseProcessor purchaseProcessor = new PurchaseProcessor(inventoryDao);
		
		DiscountOnApparel discountOnApparel = new DiscountOnApparel(scanner, processor, purchaseProcessor);
		
		discountOnApparel.buildInventory();
		
		discountOnApparel.processOrders();
		
		scanner.close();
	}
}
