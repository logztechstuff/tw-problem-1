package com.logztechstuff.discounts.processor;

import java.util.ArrayList;
import java.util.List;

import com.logztechstuff.discounts.dao.InventoryDao;
import com.logztechstuff.discounts.model.Inventory;

public class PurchaseProcessor {
	
	private final InventoryDao inventoryDao;
	
	public PurchaseProcessor(final InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
	public List<Double> calculateTotalBill(List<String> items) {
		
		List<Double> bills = new ArrayList<>();
		
		for(String item: items) {

			String[] purchasedItems = item.split(",");
			
			double totalBill = 0;

			for(String purchasedItem: purchasedItems) {
				if(inventoryDao.exists(Integer.parseInt(purchasedItem))) {
					final Inventory inventory = inventoryDao.get(Integer.parseInt(purchasedItem));
					totalBill += inventory.getDiscountedPrice();
				}
			}
			
			bills.add(totalBill);
		}
		
		return bills;
	}

}
