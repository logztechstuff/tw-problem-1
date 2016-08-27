package com.logztechstuff.discounts.model;

public class Brand {
	
	private String name;
	private double discount;
	
	public Brand(final String name, final double discount) {
		this.name = name;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Brand [name=" + name + ", discount=" + discount + "]";
	}
}
