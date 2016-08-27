package com.logztechstuff.discounts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logztechstuff.discounts.model.Inventory;

public class InventoryDaoImpl implements InventoryDao {

	private final static Map<Integer, Inventory> inventories = new HashMap<>();
	
	@Override
	public void save(Inventory inventory) {
		if(inventories.containsKey(inventory.getId())) {
			System.out.println("Brand with id " + inventory.getId() + " already exists");
		}
		inventories.put(inventory.getId(), inventory);
	}

	@Override
	public Inventory get(int id) {
		return inventories.get(id);
	}

	@Override
	public void update(Inventory inventory) {
		if(!inventories.containsKey(inventory.getId())) {
			System.out.println("Brand with id " + inventory.getId() + " does not exist");
		}
		inventories.put(inventory.getId(), inventory);
	}

	@Override
	public Inventory delete(int id) {
		return inventories.remove(id);
	}

	@Override
	public List<Inventory> getAll() {
		return (List<Inventory>) inventories.values();
	}

	@Override
	public boolean exists(int id) {
		return inventories.containsKey(id);
	}
}
