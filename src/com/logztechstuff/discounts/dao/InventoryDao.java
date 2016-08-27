package com.logztechstuff.discounts.dao;

import java.util.List;

import com.logztechstuff.discounts.model.Inventory;

public interface InventoryDao {
	
	void save(Inventory inventory);
	
	Inventory get(int id);
	
	List<Inventory> getAll();
	
	void update(Inventory inventory);
	
	Inventory delete(int id);
	
	boolean exists(int id);
}
