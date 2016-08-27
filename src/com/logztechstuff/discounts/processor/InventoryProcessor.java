package com.logztechstuff.discounts.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logztechstuff.discounts.dao.InventoryDao;
import com.logztechstuff.discounts.model.Brand;
import com.logztechstuff.discounts.model.Category;
import com.logztechstuff.discounts.model.Inventory;

public class InventoryProcessor {
	
	private InventoryDao inventoryDao;
	
	public final static Map<String, Category> categories = new HashMap<>();
	
	public final static Map<String, Brand> brands = new HashMap<>();
	
	static {
		Category mensWear = new Category("Men's wear", 0);
		Category shirts = new Category("Shirts", 0, mensWear);
		Category trousers = new Category("Trousers", 0, mensWear);
		Category casuals = new Category("Casuals", 30, mensWear);
		Category jeans = new Category("Jeans", 20, mensWear);
		
		Category womensWear = new Category("Women's wear", 50);
		Category dresses = new Category("Dresses", 0, womensWear);
		Category footwear = new Category("Footwear", 0, womensWear);
		
		categories.put(mensWear.getName(), mensWear);
		categories.put(shirts.getName(), shirts);
		categories.put(trousers.getName(), trousers);
		categories.put(casuals.getName(), casuals);
		categories.put(jeans.getName(), jeans);
		categories.put(womensWear.getName(), womensWear);
		categories.put(dresses.getName(), dresses);
		categories.put(footwear.getName(), footwear);
		
		Brand wrangler = new Brand("Wrangler", 10);
		Brand arrow = new Brand("Arrow", 20);
		Brand veroModa = new Brand("Vero Moda", 60);
		Brand ucb = new Brand("UCB", 0);
		Brand adidas = new Brand("Adidas", 5);
		Brand provogue = new Brand("Provogue", 20);
		
		brands.put(wrangler.getName(), wrangler);
		brands.put(arrow.getName(), arrow);
		brands.put(veroModa.getName(), veroModa);
		brands.put(ucb.getName(), ucb);
		brands.put(adidas.getName(), adidas);
		brands.put(provogue.getName(), provogue);
	}
	
	public InventoryProcessor(final InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}
	
	public void addToInventory(List<String> items) {
		for(String item : items) {
			String[] itemsprops = item.split(",");
			if(itemsprops.length != 4) {
				continue;
			}
			if(!brands.containsKey(itemsprops[1].trim())) {
				continue;
			}
			Brand brand = brands.get(itemsprops[1].trim());
			if(!categories.containsKey(itemsprops[2].trim())) {
				continue;
			}
			Category category = categories.get(itemsprops[2].trim());
			double price = Double.parseDouble(itemsprops[3].trim());
			
			final Inventory inventory = new Inventory(Integer.valueOf(itemsprops[0].trim()), brand, category, price);	

			inventoryDao.save(inventory);
		}
	}
}
