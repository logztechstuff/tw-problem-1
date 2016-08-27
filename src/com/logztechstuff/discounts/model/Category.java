package com.logztechstuff.discounts.model;

public class Category {
	
	private String name;
	private double discount;
	private Category parent;

	public Category(final String name, final double discount) {
		this.name = name;
		this.discount = discount;
	}
	
	public Category(final String name, final double discount, Category parent) {
		this(name, discount);
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public double getDiscount() {
		return discount;
	}

	public Category getParent() {
		return parent;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Category [name=" + name + ", discount=" + discount + ", parent="
				+ parent + "]";
	}
}
