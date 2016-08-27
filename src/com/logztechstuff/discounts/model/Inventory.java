package com.logztechstuff.discounts.model;

public class Inventory {

	private int id;
	private Brand brand;
	private Category category;
	private double price;
	private double discountedPrice;
	
	public Inventory(final int id, final Brand brand, final Category category, final double price) {
		this.id = id;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.discountedPrice = getDiscountedPrice(price, brand, category);
	}

	public int getId() {
		return id;
	}

	public Brand getBrand() {
		return brand;
	}

	public Category getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}
	
	public double getDiscountedPrice() {
		return discountedPrice;
	}

	private double getDiscountedPrice(double price, Brand brand, Category category) {
		final double brandDiscount = brand.getDiscount();
		final double categoryDiscount = getCategoryMaxDiscount(category);
		final double discount = 100 - (brandDiscount > categoryDiscount ? brandDiscount : categoryDiscount);
		final double discountedPrice = (double) ((price * discount) / 100); 
		return discountedPrice;
	}
	
	private double getCategoryMaxDiscount(Category category) {
		double maxDiscount = category.getDiscount();
		while(category.getParent() != null) {
			category = category.getParent();
			maxDiscount = maxDiscount > category.getDiscount() ? maxDiscount : category.getDiscount();
		}
		return maxDiscount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", brand=" + brand + ", category="
				+ category + ", price=" + price + ", discountedPrice="
				+ discountedPrice + "]";
	}
}